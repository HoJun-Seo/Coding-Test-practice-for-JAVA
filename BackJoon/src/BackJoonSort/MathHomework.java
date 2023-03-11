package BackJoonSort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MathHomework {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new MathHomework().solution();
    }

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        List<BigInteger> list = new ArrayList<>();

        for (int i = 0; i < count; i++) {

            String s = br.readLine();
            String str = "";

            for (int index = 0; index < s.length(); index++) {
                char c = s.charAt(index);

                if (c >= 48 && c <= 57) {
                    str += String.valueOf(c);
                } else {
                    if (!str.equals("")) {
                        list.add(new BigInteger(str));
                        str = "";
                    }
                }
            }

            if (!str.equals("")) {
                list.add(new BigInteger(str));
            }
        }

        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            bw.write(list.get(i) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}