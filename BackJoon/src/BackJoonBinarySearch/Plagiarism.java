package BackJoonBinarySearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Plagiarism {

    static int[] contestArray = null;

    public static void main(String[] args) throws NumberFormatException, IOException {
        new Plagiarism().solution();
    }

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        String[] inputArray = br.readLine().split(" ");
        contestArray = new int[count];

        for (int i = 0; i < count; i++) {
            contestArray[i] = Integer.parseInt(inputArray[i]);
        }

        Arrays.sort(contestArray);

        long comCount = 0; // 총 비교횟수

        for (int i = 0; i < contestArray.length - 1; i++) {
            int number = contestArray[i];

            if (number >= 0.9 * contestArray[i + 1]) { // 시작 지점의 바로 다음 요소부터 비교 가능한 경우
                int index = upperBound(number, i);
                comCount += (index - i);
            }
            // 시작 지점의 바로 다음 요소부터 비교 불가능한 경우 따로 로직을 수행하지 않음
        }

        bw.write(comCount + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    // 중복이 존재하는 배열에서 최초로 현재 탐색중인 파일 크기의 90퍼센트 보다 더 큰 파일의 위치를 찾는다.
    private static int upperBound(int number, int i) {
        int start = i + 1;
        int end = contestArray.length;

        while (start < end) {
            int mid = (start + end) / 2;
            if (contestArray[mid] * 0.9 <= number) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start - 1;
    }
}