package logic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class BL {
    public String getHTML(String URL) {

        java.net.URL url;
        StringBuffer sb = new StringBuffer();

        try {
            // get URL content

            url = new URL(URL);
            URLConnection conn = url.openConnection();

            // open the stream and put it into BufferedReader
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));

            String inputLine;
            while ((inputLine = br.readLine()) != null) {
                sb.append(inputLine);
            }
            br.close();

            System.out.println("Done");

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public ArrayList<String> parseURL(String URL) {
        int firstBracket = -1, secondBracket = -1, colon = -1;
        char[] temp = URL.toCharArray();
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == '[') {
                firstBracket = i;
                break;
            }
        }
        for (int i = firstBracket + 1; i < temp.length; i++) {
            if (temp[i] == ']') {
                secondBracket = i;
                break;
            }
        }
        for (int i = firstBracket + 1; i < secondBracket; i++) {
            if (temp[i] == ':') {
                colon = i;
                break;
            }
        }

        int start = Integer.parseInt(URL.substring(firstBracket + 1, colon)),
                end = Integer.parseInt(URL.substring(colon + 1, secondBracket));
        ArrayList<String> list = new ArrayList<>();
        String newURL = URL.substring(0, firstBracket);
        for (int i = start; i < end + 1; i++) {
            list.add(newURL + i);
        }
        return list;
    }

    public int getLenght(String URL) {
        int firstBracket = -1, secondBracket = -1, colon = -1;
        char[] temp = URL.toCharArray();
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == '[') {
                firstBracket = i;
                break;
            }
        }
        for (int i = firstBracket + 1; i < temp.length; i++) {
            if (temp[i] == ']') {
                secondBracket = i;
                break;
            }
        }
        for (int i = firstBracket + 1; i < secondBracket; i++) {
            if (temp[i] == ':') {
                colon = i;
                break;
            }
        }

        int start = Integer.parseInt(URL.substring(firstBracket + 1, colon)),
                end = Integer.parseInt(URL.substring(colon + 1, secondBracket));
        return end - start;
    }

    public int getPercent(int y, int x) {
        return (y / x) * 100;
    }

    public static final boolean BEFORE = false;
    public static final boolean AFTER = true;

    public String getLink(String HTML, String searchFor, )
}
