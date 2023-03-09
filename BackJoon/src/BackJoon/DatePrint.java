package BackJoon;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.time.LocalDate;

public class DatePrint {
    public static void main(String[] args) throws IOException {
        new DatePrint().solution();
    }

    private void solution() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        LocalDate now = LocalDate.now();

        bw.write(now + "\n");
        bw.flush();
        bw.close();
    }
}