package BackJoonSort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SeeCrossWord {
    public static void main(String[] args) throws IOException {
        new SeeCrossWord().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int r = Integer.parseInt(input[0]);
        int c = Integer.parseInt(input[1]);

        String[][] crossWord = new String[r][c];

        for (int i = 0; i < r; i++) {
            String str = br.readLine();

            for (int j = 0; j < c; j++) {
                crossWord[i][j] = String.valueOf(str.charAt(j));
            }
        }

        List<String> list = new ArrayList<>();

        for (int i = 0; i < crossWord.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < crossWord[i].length; j++) {
                if (crossWord[i][j].equals("#")) {
                    if (sb.length() >= 2) {
                        list.add(sb.toString());
                        sb.setLength(0);
                    } else {
                        sb.setLength(0);
                    }
                } else {
                    sb.append(crossWord[i][j]);
                }
            }

            if (sb.length() >= 2) {
                list.add(sb.toString());
            }
        }

        for (int i = 0; i < c; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < r; j++) {
                if (crossWord[j][i].equals("#")) {
                    if (sb.length() >= 2) {
                        list.add(sb.toString());
                        sb.setLength(0);
                    } else {
                        sb.setLength(0);
                    }
                } else {
                    sb.append(crossWord[j][i]);
                }
            }

            if (sb.length() >= 2) {
                list.add(sb.toString());
            }
        }

        Collections.sort(list);
        bw.write(list.get(0) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}