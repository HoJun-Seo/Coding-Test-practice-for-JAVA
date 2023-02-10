import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class RemeberKing {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int m = 0;
        int n = 0;
        int[] note1 = null;
        int[] note2 = null;

        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++) {
            m = Integer.parseInt(br.readLine());
            note1 = new int[m];
            String[] input1 = br.readLine().split(" ");

            // int 배열(수첩1) 에 입력받은 숫자 저장
            for (int j = 0; j < m; j++) {
                note1[j] = Integer.parseInt(input1[j]);
            }

            n = Integer.parseInt(br.readLine());
            note2 = new int[n];
            String[] input2 = br.readLine().split(" ");

            // int 배열(수첩2) 에 입력받은 숫자 저장
            for (int j = 0; j < n; j++) {
                note2[j] = Integer.parseInt(input2[j]);
            }

            // 수첩1 정렬 후 수첩2에 입력받은 순서대로 수첩1 배열을 이분탐색하여 찾고자 하는 숫자가 있는지 확인
            Arrays.sort(note1);
            int[] resultArray = new int[n];

            for (int j = 0; j < n; j++) {
                int findNumber = note2[j];
                int start = 0;
                int end = m - 1;

                int result = 0;
                // 수첩1 에서 숫자를 찾았을 경우 1, 찾지 못했을 경우 0
                while (start <= end) {
                    int mid = (start + end) / 2;
                    if (findNumber == note1[mid]) {
                        result = 1;
                        break;
                    } else {
                        if (findNumber < note1[mid]) {
                            end = mid - 1;
                        } else {
                            start = mid + 1;
                        }
                    }
                }

                resultArray[j] = result;
            }

            for (int j = 0; j < resultArray.length; j++) {
                bw.write(resultArray[j] + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}