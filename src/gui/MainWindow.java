package gui;

import logic.BL;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MainWindow {
    private JTextField tfURL;
    private JButton btTest;
    private JTextField tfSaveTo;
    private JButton btSelect;
    private JTextField tfSearchFor;
    private JComboBox cbBeforeAfter;
    private JPanel pnControls;
    private JProgressBar pbProgress;
    private JButton startButton;
    private JTextArea textArea1;
    private JLabel lbProgress;

    logic.BL bl = new BL();
    javax.swing.JFileChooser fcLoad = new javax.swing.JFileChooser();
    javax.swing.JFileChooser fcSave = new javax.swing.JFileChooser();

    public MainWindow() {
        startButton.addActionListener(actionEvent -> {
            ArrayList<String> list = bl.parseURL(tfURL.getText());
            int lenght = bl.getLenght(tfURL.getText());
            pbProgress.setMaximum(lenght);
            for (int i = 0; i < list.size(); i++) {
                String html = bl.getHTML(list.get(i));
                String partialLink = bl.getLink(html, tfSearchFor.getText(), cbBeforeAfter.getSelectedIndex() == 0);
                String dlLink = bl.buildLink(partialLink);
                textArea1.append(dlLink);
                try {
                    bl.downloadAndWrite(dlLink, tfSaveTo.getText());
                } catch (IOException e) {
                    e.printStackTrace();
                }

                textArea1.append(" ... done\n");
                pbProgress.setValue(pbProgress.getValue() + 1);
                lbProgress.setText(bl.getPercent(pbProgress.getValue(), lenght) + "%");

            }
        });
        btSelect.addActionListener(actionEvent -> {
            if (fcLoad.showOpenDialog(pnControls) == JFileChooser.APPROVE_OPTION) {
                File file = fcLoad.getSelectedFile();
                tfSaveTo.setText(file.getAbsolutePath());
            }
        });
    }

    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        JFrame frame = new JFrame("MainWindow");
        frame.setContentPane(new MainWindow().pnControls);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
