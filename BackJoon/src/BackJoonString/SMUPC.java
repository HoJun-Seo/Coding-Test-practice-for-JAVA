package BackJoonString;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SMUPC {

    static String str = "";
    static StringBuilder sb = new StringBuilder();
    static StringBuilder before = new StringBuilder();
    static StringBuilder after = new StringBuilder();
    static int index = 0;

    public static void main(String[] args) throws NumberFormatException, IOException {
        new SMUPC().solution();
    }

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int operatorCount = Integer.parseInt(br.readLine());
        str = br.readLine();

        if (!str.contains("C")) {
            bw.write("NO OUTPUT");
        } else {
            String operator = "";
            for (; index < str.length(); index++) {
                if (str.charAt(index) >= 48 && str.charAt(index) <= 57) {
                    sb.append(String.valueOf(str.charAt(index)));
                } else {
                    // 연산자 입력받음
                    if (before.length() == 0) {
                        before.append(sb.toString());
                        operator = String.valueOf(str.charAt(index));
                        sb.setLength(0);

                        if (operator.equals("C")) {
                            bw.write(Integer.parseInt(before.toString()) + " ");
                        } else {
                            before = smupc(operator);
                        }
                    } else {
                        operator = String.valueOf(str.charAt(index));
                        if (operator.equals("C")) {
                            bw.write(Integer.parseInt(before.toString()) + " ");
                        } else {
                            before = smupc(operator);
                        }
                    }
                }
            }
        }

        bw.write("\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private StringBuilder smupc(String operator) {
        for (int i = index + 1; i < str.length(); i++) {
            if (!(str.charAt(i) >= 48 && str.charAt(i) <= 57)) {
                index = i - 1;
                break;
            } else {
                sb.append(str.charAt(i));
            }
        }

        after.append(sb.toString());

        if (after.length() == 0) {
            return before;
        } else {
            long number1 = Long.parseLong(before.toString());
            long number2 = Long.parseLong(after.toString());

            if (operator.equals("S")) {
                number1 -= number2;
            } else if (operator.equals("M")) {
                number1 *= number2;
            } else if (operator.equals("U")) {
                if (number1 < 0) {
                    number1 *= -1;
                    number1 /= number2;
                    number1 *= -1;
                } else {
                    number1 /= number2;
                }
            } else if (operator.equals("P")) {
                number1 += number2;
            }

            before = new StringBuilder(String.valueOf(number1));
            after.setLength(0);
            sb.setLength(0);

            return before;
        }
    }
}