package BackJoonGreedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class HamBurger {
    public static void main(String[] args) throws IOException {
        new HamBurger().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int count = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        char[] table = new char[count];
        String str = br.readLine();
        for (int i = 0; i < str.length(); i++) {
            table[i] = str.charAt(i);
        }

        int result = 0;
        for (int i = 0; i < table.length; i++) {
            if (table[i] == 'H')
                continue;
            else if (table[i] == 'P') {
                boolean check = false;
                // 왼쪽은 멀리서부터 확인
                for (int index = i - k; index < i; index++) {
                    if (index < 0)
                        continue;
                    else {
                        if (table[index] == 'H') {
                            table[index] = 'E';
                            result++;
                            check = true;
                            break;
                        }
                    }
                }
                // 오른쪽 확인 필요한 경우 가까운 곳에서부터 확인
                if (!check) {
                    for (int index = i; index <= i + k; index++) {
                        if (index > table.length - 1)
                            break;
                        else {
                            if (table[index] == 'H') {
                                table[index] = 'E';
                                result++;
                                break;
                            }
                        }
                    }
                }
            }
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}