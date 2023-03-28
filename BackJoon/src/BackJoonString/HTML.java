package BackJoonString;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class HTML {
    public static void main(String[] args) throws IOException {
        new HTML().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        int lineLength = 0;
        while (true) {
            String str = br.readLine();
            if (str == null)
                break;
            else if (str.equals(""))
                continue;
            else {
                StringTokenizer st = new StringTokenizer(str, " \t\n");
                String[] input = new String[st.countTokens()];
                int index = 0;
                while (st.hasMoreTokens()) {
                    input[index] = st.nextToken();
                    index++;
                }
                for (String word : input) {
                    if (!word.equals("<br>") && !word.equals("<hr>")) {
                        if (lineLength == 0) {
                            sb.append(word);
                            lineLength = word.length();
                        } else if (lineLength + word.length() < 80) {
                            sb.append(" " + word);
                            lineLength += word.length() + 1;
                        } else {
                            sb.append("\n" + word);
                            lineLength = word.length();
                        }
                    } else {
                        if (word.equals("<br>")) {
                            sb.append("\n");
                            lineLength = 0;
                        } else if (word.equals("<hr>")) {
                            if (lineLength == 0) {
                                for (int i = 0; i < 80; i++) {
                                    sb.append("-");
                                }
                            } else {
                                lineLength = 0;
                                sb.append("\n");
                                for (int i = 0; i < 80; i++) {
                                    sb.append("-");
                                }
                            }
                            sb.append("\n");
                        }
                    }
                }
            }
        }

        sb.append("\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}