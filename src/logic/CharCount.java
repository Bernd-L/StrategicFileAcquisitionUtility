/*
Copyright 2017 Bernd-L.
All rights reserved.
 */

package logic;

import java.util.ArrayList;

public class CharCount {
    private int i = 0;
    private int timeOut = 0;
    private ArrayList<Character> start;
    private ArrayList<Character> end;
    private Integer difference = 0;
    private ArrayList<String> result = new ArrayList();

    /**
     * Generates strings like spreadsheet software names its columns.
     * <p>
     * example: new CharCount("a", "xfd", true);
     * will return:
     * ad
     * ae
     * af
     * ag
     * ah
     * <p>
     * Use getResult() to get an ArrayList of the calculated strings.
     *
     * @param from   The starting string
     * @param to     The last string
     * @param silent If true suppresses the immediate output to the console
     */
    public CharCount(String from, String to, boolean silent) {
        start = getArrayLisRepresentation(from);
        end = getArrayLisRepresentation(to);
        System.out.println("init complete");
        calculateStrings(new ArrayList<>(start), silent);
        System.out.println("end");
    }

    /**
     * @deprecated Only used for testing.
     * Do not use.
     */
    public static void main(String[] args) {
        CharCount cc = new CharCount("ad", "ah", true);
        for (String s : cc.getResult()) {
            System.out.println(s);
        }
        System.out.println("===============\n");
        System.out.println("length=" + cc.getResult().size());
    }

    /**
     * Converts a ArrayList<Character> to a String.
     *
     * @param list The ArrayList to be converted.
     * @return The string representation of the ArrayList.
     */
    public static String getStringRepresentation(ArrayList<Character> list) {
        StringBuilder builder = new StringBuilder(list.size());
        for (Character ch : list) {
            builder.append(ch);
        }
        return builder.toString();
    }

    /**
     * Converts a String to an ArrayList<Character>.
     *
     * @param string The string to be converted.
     * @return The ArrayList representation of the string.
     */
    public static ArrayList<Character> getArrayLisRepresentation(String string) {
        ArrayList<Character> characters = new ArrayList<>();
        char[] chars = string.toCharArray();
        for (char c : chars) {
            characters.add(c);
        }
        return characters;
    }

    /**
     * @deprecated Do not use.
     * Use getResult().size() instead.
     */
    @Deprecated
    public Integer getDifferenceLegacy() {
        return difference;
    }

    /**
     * Generates all of the strings needed.
     *
     * @param current The current String it's working on as a ArrayList<Character>.
     * @param silent  If true suppresses the immediate output to the console.
     */
    private void calculateStrings(ArrayList<Character> current, boolean silent) {
        while (true) {
            timeOut++;
            String temp = getStringRepresentation(current);
            result.add(temp); //Adds the current line to the results
            if (!silent)
                System.out.println(temp);
            if (/*timeOut == 500*/current.equals(end)) {
                System.out.println("It's equal");
                return;
            }
            i = current.size() - 1;
            boolean carry;
            do {
                carry = false;
                if (current.get(i) == 'z') { //Check carry
                    carry = true;
                    current.set(i, 'a');
                    if (i == 0) { //Check if pointer is at first char
                        current.add('a'); //Prevent outOfBoundsException
                        carry = false;
                    } else {
                        if (current.get(i - 1) == 'z') {
                            i--;
                            continue;
                        }
                        i--;
                    }

                } else { //When no carry
                    current.set(i, (char) (current.get(i) + 1));
                }
                difference++;

            } while (carry);
        }
        //calculateStrings(current);
    }

    /**
     * Used to get the calculated strings.
     *
     * @return The calculated strings in an ArrayList<String>
     */
    private ArrayList<String> getResult() {
        return result;
    }

    /**
     * Converts the result-ArrayList to a multiline String.
     * A string gets on each line.
     *
     * @return The string representation of the output.
     */
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (String s : result) {
            sb.append(s);
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}
