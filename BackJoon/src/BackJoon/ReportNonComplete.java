package BackJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ReportNonComplete {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new ReportNonComplete().solution();
    }

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[] student = new boolean[31];

        for (int i = 0; i < 28; i++) {
            int number = Integer.parseInt(br.readLine());

            student[number] = true;
        }

        for (int i = 1; i < student.length; i++) {
            if (!student[i])
                bw.write(i + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}