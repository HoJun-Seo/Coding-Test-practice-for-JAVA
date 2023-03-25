package BackJoonString;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.regex.Pattern;

public class WrongPrintFormat {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new WrongPrintFormat().solution();
    }

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++) {
            String str1 = br.readLine().trim();
            String str2 = br.readLine().trim();

            str1 = str1.toLowerCase();
            str2 = str2.toLowerCase();

            str1 = str1.replaceAll("[\\{|\\[]", "\\(");
            str1 = str1.replaceAll("[\\}|\\]]", "\\)");
            str1 = str1.replaceAll("\\;", "\\,");

            str2 = str2.replaceAll("[\\{|\\[]", "\\(");
            str2 = str2.replaceAll("[\\}|\\]]", "\\)");
            str2 = str2.replaceAll("\\;", "\\,");

            str1 = singleBlank(str1);
            str2 = singleBlank(str2);

            str1 = blankRMsk(str1);
            str2 = blankRMsk(str2);

            String result = "";
            if (str1.equals(str2))
                result = "equal";
            else
                result = "not equal";

            bw.write("Data Set " + (i + 1) + ": " + result + "\n\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private String singleBlank(String str) {

        StringBuilder sb = new StringBuilder(str);
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                i++;
                while (str.charAt(i) == ' ') {
                    sb.setCharAt(i, '*');
                    i++;
                }
            }
        }

        str = sb.toString().replaceAll("\\*", "");
        return str;
    }

    private String blankRMsk(String str) {

        String pattern = "[\\(|\\)|\\.|\\,|\\:]";
        StringBuilder sb = new StringBuilder(str);

        for (int i = 0; i < str.length(); i++) {
            if (Pattern.matches(pattern, String.valueOf(str.charAt(i)))) {
                for (int index = i - 1; index >= 0; index--) {
                    if (str.charAt(index) != ' ')
                        break;
                    else {
                        sb.setCharAt(index, '*');
                    }
                }
                for (int index = i + 1; index < str.length(); index++) {
                    if (str.charAt(index) != ' ')
                        break;
                    else {
                        sb.setCharAt(index, '*');
                    }
                }
            }
        }
        str = sb.toString().replaceAll("\\*", "");
        return str;
    }
}