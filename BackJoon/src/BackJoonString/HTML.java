package BackJoonString;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class HTML {
    public static void main(String[] args) throws IOException {
        new HTML().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        while (true) {
            String str = br.readLine();
            if (str == null)
                break;
            else {
                if (str.equals(""))
                    continue;
                else {
                    str = singleBlank(str);
                    String[] word = str.split(" ");
                    for (int i = 0; i < word.length; i++) {
                        if (!word[i].contains("<br>") && !word[i].contains("<hr>")) {
                            if (sb.length() + word[i].length() > 80) {
                                sb = new StringBuilder(sb.toString().trim());
                                bw.write(sb.toString() + "\n");
                                sb.setLength(0);
                                sb.append(word[i] + " ");
                            } else if (sb.length() + word[i].length() <= 80) {
                                sb.append(word[i] + " ");
                            }
                        } else if (word[i].contains("<br>") || word[i].contains("<hr>")) {

                            word[i] = word[i].replaceAll("<br>", "\\$").replaceAll("<hr>", "\\%");

                            StringBuilder keyword = new StringBuilder();
                            for (int j = 0; j < word[i].length(); j++) {
                                if (word[i].charAt(j) != '$' && word[i].charAt(j) != '%') {
                                    keyword.append(String.valueOf(word[i].charAt(j)));
                                } else {
                                    if (word[i].charAt(j) == '$') {
                                        if (sb.length() + keyword.length() > 80) {
                                            sb = new StringBuilder(sb.toString().trim());
                                            bw.write(sb.toString() + "\n");
                                            sb.setLength(0);
                                        }
                                        if (keyword.length() > 0 || sb.length() > 0) {
                                            if (keyword.length() > 0) {
                                                sb.append(keyword.toString());
                                                keyword.setLength(0);
                                            }
                                            if (sb.length() > 0) {
                                                bw.write(sb.toString() + "\n");
                                                sb.setLength(0);
                                            }
                                        } else if (keyword.length() <= 0 && sb.length() <= 0) {
                                            bw.write("\n");
                                        }

                                        sb.setLength(0);
                                    } else if (word[i].charAt(j) == '%') {
                                        if (sb.length() + keyword.length() > 80) {
                                            sb = new StringBuilder(sb.toString().trim());
                                            bw.write(sb.toString() + "\n");
                                            sb.setLength(0);
                                        }
                                        if (keyword.length() > 0) {
                                            sb.append(keyword.toString());
                                            keyword.setLength(0);
                                        }

                                        if (sb.length() > 0) {
                                            bw.write(sb.toString() + "\n");
                                            sb.setLength(0);
                                        }

                                        for (int x = 0; x < 80; x++) {
                                            bw.write("-");
                                        }
                                        bw.write("\n");
                                    }
                                }
                            }

                            if (keyword.length() > 0) {
                                if (sb.length() + keyword.length() > 80) {
                                    sb = new StringBuilder(sb.toString().trim());
                                    bw.write(sb.toString() + "\n");
                                    sb.setLength(0);
                                }
                                sb.append(keyword.toString());
                                keyword.setLength(0);
                            }
                        }
                    }
                }
            }
        }
        if (sb.length() > 0) {
            sb = new StringBuilder(sb.toString().trim());
            bw.write(sb.toString() + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private String singleBlank(String str) {
        StringBuilder sb = new StringBuilder(str);
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == ' ') {
                for (int j = i + 1; j < sb.length(); j++) {
                    if (sb.charAt(j) == ' ') {
                        sb.setCharAt(j, '*');
                    } else
                        break;
                }
            }
        }
        str = sb.toString().replaceAll("\\*", "");
        return str;
    }
}