package BackJoonSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Plagiarism {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        String[] inputArray = br.readLine().split(" ");
        int[] contestArray = new int[count];

        for (int i = 0; i < count; i++) {
            contestArray[i] = Integer.parseInt(inputArray[i]);
        }

        Arrays.sort(contestArray);

        long comCount = 0;

        for (int i = 0; i < contestArray.length - 1; i++) {
            int number = contestArray[i];

            int start = i + 1;
            int end = contestArray.length - 1;
            int indexCount = start;

            if (number < 0.9 * contestArray[i + 1]) { // 시작지점의 바로 다음 요소부터 이미 비교가 불가능할 경우
                indexCount = i;
            } else {
                while (start <= end) { // 시작과 끝 지점이 같아질 때까지 진행
                    int mid = (start + end) / 2;
                    int comPNum = contestArray[mid];
                    if (comPNum * 0.9 <= number) {
                        indexCount = mid; // 비교 가능한 요소 인덱스 저장(비교 가능 최대값으로 가정)
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                }
            }
            comCount += (indexCount - i);
        }

        bw.write(comCount + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}