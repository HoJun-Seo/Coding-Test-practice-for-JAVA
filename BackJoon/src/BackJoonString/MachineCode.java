package BackJoonString;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MachineCode {
    public static void main(String[] args) throws IOException {
        new MachineCode().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        int index = 0;
        int nopInclude = 0;
        while (index < s.length()) {

            // 대문자 입력이 들어왔을 경우
            if (s.charAt(index) >= 65 && s.charAt(index) <= 90) {

            }
        }
    }
}
