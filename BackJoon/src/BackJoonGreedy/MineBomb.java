package BackJoonGreedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MineBomb {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new MineBomb().solution();
    }

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        int[] mineArray = new int[count];

        for (int i = 0; i < count; i++) {
            mineArray[i] = Integer.parseInt(br.readLine());
        }

        if (count == 1) {
            bw.write(1 + "\n");
        } else {
            // 어차피 순차탐색 중이므로 터뜨려야 하는 지뢰를 찾았을 때 별다른 정렬 로직을 사용할 필요 없이
            // 바로 출력해주면 된다.
            for (int i = 0; i < mineArray.length; i++) {
                // 시작 지점을 터뜨려야 할 경우
                if (i == 0) {
                    if (mineArray[i] >= mineArray[i + 1]) {
                        bw.write((i + 1) + "\n");
                    }
                }
                // 마지막 지점을 터뜨려야 할 경우
                else if (i == mineArray.length - 1) {
                    if (mineArray[i] >= mineArray[i - 1]) {
                        bw.write((i + 1) + "\n");
                    }
                }
                // 중간 지점을 터뜨려야 할 경우
                else {
                    if (mineArray[i] >= mineArray[i - 1] && mineArray[i] >= mineArray[i + 1]) {
                        bw.write((i + 1) + "\n");
                    }
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}