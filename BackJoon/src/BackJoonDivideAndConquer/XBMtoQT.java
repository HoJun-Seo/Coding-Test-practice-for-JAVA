package BackJoonDivideAndConquer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class XBMtoQT {

    static String[][] quadTree = null;

    public static void main(String[] args) throws IOException {
        new XBMtoQT().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int size = Integer.parseInt(input[input.length - 1]);

        quadTree = new String[size][size];

        br.readLine();
        br.readLine();

        for (int i = 0; i < size; i++) {
            input = br.readLine().split(",");

            StringBuilder line = new StringBuilder();
            for (int j = 0; j < input.length; j++) {
                String str = input[j];
                str = str.substring(2, str.length());

                int decimal = Integer.parseInt(str, 16);
                String binary = Integer.toBinaryString(decimal);
                StringBuilder sb = new StringBuilder(binary);

                while (sb.length() < 8) {
                    sb.insert(0, "0");
                }

                sb = sb.reverse();
                line.append(sb.toString());
            }

            for (int j = 0; j < line.length(); j++) {
                String keyword = String.valueOf(line.charAt(j));
                if (keyword.equals("0"))
                    keyword = "W";
                else if (keyword.equals("1"))
                    keyword = "B";

                quadTree[i][j] = keyword;
            }
        }

        br.readLine();

        String result = xbmToqt(0, size, 0, size);
        bw.write(size + "\n");
        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private String xbmToqt(int x1, int x2, int y1, int y2) {
        String standard = quadTree[x1][y1];
        boolean check = true;
        for (int i = x1; i < x2; i++) {
            for (int j = y1; j < y2; j++) {
                if (!standard.equals(quadTree[i][j])) {
                    check = false;
                    break;
                }
            }
        }

        if (check)
            return standard;
        else {
            StringBuilder sb = new StringBuilder("Q");
            sb.append(xbmToqt(x1, (x1 + x2) / 2, y1, (y1 + y2) / 2));
            sb.append(xbmToqt(x1, (x1 + x2) / 2, (y1 + y2) / 2, y2));
            sb.append(xbmToqt((x1 + x2) / 2, x2, y1, (y1 + y2) / 2));
            sb.append(xbmToqt((x1 + x2) / 2, x2, (y1 + y2) / 2, y2));

            return sb.toString();
        }
    }
}