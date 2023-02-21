import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class GuitarLesson {

    static int N = 0;
    static int M = 0;
    static int[] lesson = null;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputArray = br.readLine().split(" ");
        N = Integer.parseInt(inputArray[0]);
        M = Integer.parseInt(inputArray[1]);

        lesson = new int[N];
        inputArray = br.readLine().split(" ");
        for (int i = 0; i < lesson.length; i++) {
            lesson[i] = Integer.parseInt(inputArray[i]);
        }

        int start = 0;
        // 최악의 경우 : 모든 강의가 한 개의 블루레이 안에 들어갈경우
        int end = Arrays.stream(lesson).sum();

        while (start <= end) {
            int mid = (start + end) / 2;

            // 블루레이의 최대 길이가 mid 시간일때 블루레이 안에 강의를 얼마나 넣을수 있는지 확인
            // 블루레이 필요 갯수 M이하로 강의들을 저장할 수 있으면 end 를 줄인다.
            // 반대의 경우 start 를 늘린다.

            if (check(mid)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        bw.write(start + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean check(int mid) {

        boolean result = false;
        int count = 0; // 사용되는 블루레이 갯수
        int videoLength = 0;
        for (int i = 0; i < lesson.length; i++) {

            if (videoLength + lesson[i] <= mid) {
                videoLength += lesson[i];
            } else {
                count++;
                if (count > M) {
                    break;
                }
                videoLength = 0;
                i--;
            }
        }

        // videoLength 가 0 인 경우는 애초에 for 문에서 빠져나오지 않음
        if (videoLength > 0) {
            count++;
        }

        if (count <= M) {
            result = true;
        }
        return result;
    }
}