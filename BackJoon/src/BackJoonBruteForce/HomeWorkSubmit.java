package BackJoonBruteForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.time.LocalDate;

public class HomeWorkSubmit {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new HomeWorkSubmit().solution();
    }

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++) {
            String[] input = br.readLine().split(" ");

            String[] deadLine = input[0].split("\\/");
            String[] submit = input[1].split("\\/");

            LocalDate deadLineDate = LocalDate.of(Integer.parseInt(deadLine[2]), Integer.parseInt(deadLine[0]),
                    Integer.parseInt(deadLine[1]));
            LocalDate submitDate = LocalDate.of(Integer.parseInt(deadLine[2]), Integer.parseInt(submit[0]),
                    Integer.parseInt(submit[1]));

            if (deadLineDate.equals(submitDate))
                bw.write("SAME DAY\n");
            else {
                boolean check = false;

                for (int day = 1; day <= 7; day++) {
                    LocalDate date = deadLineDate.plusDays(day);
                    submitDate = LocalDate.of(date.getYear(), Integer.parseInt(submit[0]),
                            Integer.parseInt(submit[1]));
                    if (date.equals(submitDate)) {
                        bw.write(submitDate.getMonthValue() + "/" + submitDate.getDayOfMonth() + "/"
                                + submitDate.getYear() + " IS ");
                        String singleORduple = "";
                        if (day == 1)
                            singleORduple = " DAY";
                        else
                            singleORduple = " DAYS";
                        bw.write(day + singleORduple + " AFTER\n");
                        check = true;
                        break;
                    }
                }

                for (int day = 1; day <= 7; day++) {
                    LocalDate date = deadLineDate.minusDays(day);
                    submitDate = LocalDate.of(date.getYear(), Integer.parseInt(submit[0]),
                            Integer.parseInt(submit[1]));
                    if (date.equals(submitDate)) {
                        bw.write(submitDate.getMonthValue() + "/" + submitDate.getDayOfMonth() + "/"
                                + submitDate.getYear() + " IS ");
                        String singleORduple = "";
                        if (day == 1)
                            singleORduple = " DAY";
                        else
                            singleORduple = " DAYS";
                        bw.write(day + singleORduple + " PRIOR\n");
                        check = true;
                        break;
                    }
                }

                if (!check) {
                    bw.write("OUT OF RANGE\n");
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}