package BackJoonBinarySearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class RemeberKing {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new RemeberKing().solution();
    }

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            int n = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");

            int[] note = new int[n];
            for (int j = 0; j < n; j++) {
                note[j] = Integer.parseInt(input[j]);
            }

            Arrays.sort(note);

            int m = Integer.parseInt(br.readLine());
            input = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                int findNumber = Integer.parseInt(input[j]);

                int start = 0;
                int end = n - 1;
                boolean find = false;
                while (start <= end) {
                    int mid = (start + end) / 2;

                    if (note[mid] == findNumber) {
                        bw.write(1 + "\n");
                        find = true;
                        break;
                    } else if (note[mid] > findNumber) {
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                    }
                }

                if (!find) {
                    bw.write(0 + "\n");
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}