package BackJoonGreedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class RoomEscape {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new RoomEscape().solution();
    }

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] buttonArray = new int[count];
        for (int i = 0; i < buttonArray.length; i++) {
            buttonArray[i] = Integer.parseInt(input[i]);
        }

        // 역으로 불을 끄는 경우를 생각
        int result = 0;
        while (Arrays.stream(buttonArray).anyMatch(x -> x == 1)) {
            for (int i = 0; i < buttonArray.length; i++) {
                if (buttonArray[i] == 1) {
                    buttonArray[i] = 0;
                    if (i <= buttonArray.length - 3) {
                        if (buttonArray[i + 1] == 1)
                            buttonArray[i + 1] = 0;
                        else
                            buttonArray[i + 1] = 1;

                        if (buttonArray[i + 2] == 1)
                            buttonArray[i + 2] = 0;
                        else
                            buttonArray[i + 2] = 1;
                    } else if (i == buttonArray.length - 2) {
                        if (buttonArray[i + 1] == 1)
                            buttonArray[i + 1] = 0;
                        else
                            buttonArray[i + 1] = 1;
                    }

                    result++;
                }
            }
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}