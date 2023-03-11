package BackJoonString;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class PageCount {
    public static void main(String[] args) throws IOException {
        new PageCount().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {

            String s = br.readLine();

            if (s.equals("0"))
                break;
            else {
                String[] pageArray = br.readLine().split(",");

                // 출력되는 페이지를 저장하기 위한 Set 자료구조
                // 중복이 허용되지 않음
                Set<Integer> pageSet = new HashSet<>();

                for (int i = 0; i < pageArray.length; i++) {
                    // 하이픈이 포함되어 있지 않은 경우
                    if (!pageArray[i].contains("-")) {
                        // 페이지가 1부터 시작한다는 것과 최대 출력범위가 존재한다는 것을 고려할것
                        int number = Integer.parseInt(pageArray[i]);
                        if (number < 1 || number > Integer.parseInt(s))
                            continue;
                        else
                            pageSet.add(Integer.parseInt(pageArray[i]));

                    } else {
                        String[] lowHigh = pageArray[i].split("-");

                        int low = Integer.parseInt(lowHigh[0]);
                        int high = Integer.parseInt(lowHigh[1]);

                        if (low > high)
                            continue;
                        else if (low <= high) {
                            // 출력할수 있는 최대 범위 고려할것
                            if (high > Integer.parseInt(s))
                                high = Integer.parseInt(s);

                            // 페이지는 1부터 시작함
                            // 페이지가 0부터 시작할 경우 1부터 시작하는걸로 범위를 조정해야함
                            while (low <= high) {
                                if (low >= 1)
                                    pageSet.add(low);
                                low++;

                            }
                        }
                    }
                }
                bw.write(pageSet.size() + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}