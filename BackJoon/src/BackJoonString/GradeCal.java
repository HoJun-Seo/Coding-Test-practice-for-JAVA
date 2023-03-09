package BackJoonString;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class GradeCal {
    public static void main(String[] args) throws IOException {
        new GradeCal().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        String result = "";

        switch (s) {
            case "A+":
                result = "4.3";
                break;
            case "A0":
                result = "4.0";
                break;
            case "A-":
                result = "3.7";
                break;
            case "B+":
                result = "3.3";
                break;
            case "B0":
                result = "3.0";
                break;
            case "B-":
                result = "2.7";
                break;
            case "C+":
                result = "2.3";
                break;
            case "C0":
                result = "2.0";
                break;
            case "C-":
                result = "1.7";
                break;
            case "D+":
                result = "1.3";
                break;
            case "D0":
                result = "1.0";
                break;
            case "D-":
                result = "0.7";
                break;
            case "F":
                result = "0.0";
                break;
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}