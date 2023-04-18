package BackJoonGreedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;

public class ItemArrangement {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new ItemArrangement().solution();
    }

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(br.readLine());
        Integer[] array = new Integer[size];
        String[] input = br.readLine().split(" ");
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            array[i] = Integer.parseInt(input[i]);
            min = Math.min(min, array[i]);
        }

        Arrays.sort(array, Collections.reverseOrder());
        int maxIndex = 0;

        if (min >= 1) {
            bw.write(size + "\n");
        } else {
            for (int i = 0; i < array.length; i++) {
                if (array[i] == 0)
                    continue;
                else {
                    // -1 을 하는 이유 -> 자기자신 또한 강화되므로 강화수치 - 1 을 해줘야 함
                    int index = i + array[i] - 1;
                    maxIndex = Math.max(index, maxIndex);
                }
            }
            // +1 을 하는 이유 : 배열에서 index 값은 0부터 시작하기 때문에 현실적인 갯수를 맞춰주기 위함
            if (maxIndex + 1 > array.length) {
                // 강화 되는 인덱스 길이가 배열을 초과하는 경우
                // 즉, 배열 순서를 한 바퀴 돌아서 가장 첫번째 위치가 한번 더 강화되는 경우
                bw.write(array.length + "\n");
            } else if (array[0] == 0) {
                bw.write(0 + "\n");
            } else {
                bw.write((maxIndex + 1) + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}