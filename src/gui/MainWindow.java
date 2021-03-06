package gui;

import logic.BL;
import logic.CharCount;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MainWindow {
    logic.BL bl = new BL();
    javax.swing.JFileChooser fcLoad = new javax.swing.JFileChooser();
    javax.swing.JFileChooser fcSave = new javax.swing.JFileChooser();
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
    private JTextField tfHostName;
    private JButton helpAboutButton;

    public MainWindow() {
        startButton.addActionListener(actionEvent -> {
            ArrayList<String> list = bl.parseURL(tfURL.getText());
            int lenght = bl.getLenght(tfURL.getText());
            pbProgress.setMaximum(lenght);
            for (int i = 0; i < list.size(); i++) {
                String html = bl.getHTML(list.get(i));
                String partialLink = bl.getLink(html, tfSearchFor.getText(), cbBeforeAfter.getSelectedIndex() == 0);
                String dlLink = bl.buildLink(tfHostName.getText(), partialLink);
                textArea1.append(dlLink + "\n");
                try {
                    bl.downloadAndWrite(dlLink, tfSaveTo.getText());
                } catch (IOException e) {
                    e.printStackTrace();
                }

                //textArea1.append(" ... done\n");
                pbProgress.setValue(i);
                lbProgress.setText(bl.getPercent(i, lenght) + "%");
                System.out.println(String.format("%4d %3d%s ", i, bl.getPercent(i, lenght), "%") + dlLink);

            }
        });
        btSelect.addActionListener(actionEvent -> {
            fcLoad.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            fcLoad.setAcceptAllFileFilterUsed(false);
            if (fcLoad.showOpenDialog(pnControls) == JFileChooser.APPROVE_OPTION) {
                File file = fcLoad.getCurrentDirectory();
                tfSaveTo.setText(file.getAbsolutePath());
            }
        });
        btTest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String s = JOptionPane.showInputDialog("Start:");
                String s1 = JOptionPane.showInputDialog("Stop:");
                //boolean b = JOptionPane.showConfirmDialog(null, "Dump output in real time to the console?\nWARNING: Launching ", "Instant output?", JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION;

                CharCount cc = new CharCount(s, s1, true);
                textArea1.setText(cc.toString());

                /*try {
                    URL url = new URL(tfURL.getText());
                } catch (InvalidURLException e) {
                    e.printStackTrace();
                }*/
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
        frame.setPreferredSize(new Dimension(500, 600));
        frame.setContentPane(new MainWindow().pnControls);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Strategic File Acquisition Utility - github.com/Bernd-L");
        frame.pack();
        frame.setVisible(true);
    }
}
