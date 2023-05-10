package BackJoonBinarySearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class DarkBridge {

    static int[] lampArray;
    static int bridgeLength;

    public static void main(String[] args) throws NumberFormatException, IOException {
        new DarkBridge().solution();
    }

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bridgeLength = Integer.parseInt(br.readLine());

        int count = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        lampArray = new int[count]; // 가로등 위치표시 배열
        for (int i = 0; i < lampArray.length; i++) {
            lampArray[i] = Integer.parseInt(input[i]);
        }

        int start = 0;
        int end = bridgeLength;
        int result = 0;
        while (start <= end) {
            int mid = (start + end) / 2;

            // 가로등의 높이가 mid 값일 때 굴다리를 모두 밝힐 수 있는 경우 end 값을 줄임
            if (lightCheck(mid)) {
                result = mid;
                end = mid - 1;
            } else {
                // 가로등의 높이가 mid 일 때 굴다리를 모두 밝힐 수 없는 경우 start 값을 늘림
                start = mid + 1;
            }
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private boolean lightCheck(int mid) {
        // 이전 가로등이 밝힌 마지막 지점
        // 0 지점부터 모두 밝혀야 하므로 0 부터 시작
        int prev = 0;

        for (int i = 0; i < lampArray.length; i++) {
            // 현재 가로등이 설치된 위치에서 밝힐 수 있는 범위중
            // 왼쪽 끝부분이 이전에 있던 가로등이 밝힌 마지막 지점보다 작거나 같다면
            if (lampArray[i] - mid <= prev) {
                // 현재 가로등이 설치된 위치에서 밝힐 수 있는 범위중
                // 오른쪽 부분 까지 모두 밝혀주면서
                // 이전 가로등이 밝힌 마지막 지점 변수를 초기화 해준다.
                prev = lampArray[i] + mid;
            } else {
                // 이전 가로등이 밝힌 마지막 지점과,
                // 현재 가로등이 밝힐 수 있는 왼쪽 끝 지점이 만나거나 겹치지 않는다면
                // 즉, 가로등으로 밝힐 수 없는 지점이 존재한다면
                return false;
            }
        }

        // 굴다리의 마지막 지점도 가로등으로 밝혀지는 지 확인해야함
        if (bridgeLength - prev > 0) {
            // 가로등으로 밝힌 마지막 지점보다 굴다리의 총 길이가 더 길다면
            return false;
        } else {
            // 가로등으로 밝힌 마지막 지점이 굴다리의 길이와 일치하거나 더 넓다면
            return true;
        }
    }
}