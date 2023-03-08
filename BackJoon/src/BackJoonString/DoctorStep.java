package BackJoonString;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class DoctorStep {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new DoctorStep().solution();
    }

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        String[] resultArray = new String[count];

        for (int i = 0; i < count; i++) {
            String str = br.readLine();

            if (str.contains("+")) {
                String[] numberArray = str.split("\\+");
                int number1 = Integer.parseInt(numberArray[0]);
                int number2 = Integer.parseInt(numberArray[1]);

                int result = number1 + number2;
                resultArray[i] = String.valueOf(result);

            } else if (str.equals("P=NP")) {
                resultArray[i] = "skipped";
            }
        }

        for (int i = 0; i < resultArray.length; i++) {
            bw.write(resultArray[i] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}