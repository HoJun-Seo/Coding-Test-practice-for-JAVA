package BackJoonString;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class PlusSeven {

    static HashMap<Integer, Integer> segementMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        new PlusSeven().solution();
    }

    private void solution() throws IOException {

        segementMap.put(63, 0);
        segementMap.put(10, 1);
        segementMap.put(93, 2);
        segementMap.put(79, 3);
        segementMap.put(106, 4);
        segementMap.put(103, 5);
        segementMap.put(119, 6);
        segementMap.put(11, 7);
        segementMap.put(127, 8);
        segementMap.put(107, 9);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<String> resultQueue = new LinkedList<>();

        while (true) {
            String input = br.readLine();
            if (input.equals("BYE"))
                break;

            StringTokenizer st = new StringTokenizer(input, "+=");
            String[] code = new String[2];

            int i = 0;
            while (st.hasMoreTokens()) {
                code[i] = st.nextToken();
                i++;
            }

            int sum = 0;
            for (int index = 0; index < code.length; index++) {

                // 입력받은 10진수 코드를 3자리씩 자른다.
                String str = "";
                Queue<String> queue = new LinkedList<>();
                for (int j = 0; j < code[index].length(); j++) {
                    if ((j + 1) % 3 == 0) {
                        str += String.valueOf(code[index].charAt(j));
                        queue.offer(str);
                        str = "";
                    } else {
                        str += String.valueOf(code[index].charAt(j));
                    }
                }

                String numStr = "";
                while (!queue.isEmpty()) {
                    int number = Integer.parseInt(queue.poll());
                    numStr += String.valueOf(segementMap.get(number));
                }

                sum += Integer.parseInt(numStr);
            }

            // 합계로 구해진 sum 의 각 자리를 세그먼트로 표현했을 때 나오는 2진수를 다시 10진수로 변환한 결과를
            // 붙여서 출력해준다.
            String result = String.valueOf(sum);
            String resultStr = "";
            Object[] keyArray = segementMap.keySet().toArray();
            for (int j = 0; j < result.length(); j++) {

                int number = Character.getNumericValue(result.charAt(j));
                for (int x = 0; x < keyArray.length; x++) {
                    if (number == segementMap.get((int) keyArray[x])) {
                        String temp = String.valueOf(keyArray[x]);
                        if (temp.length() == 2) {
                            temp = "0" + temp;
                        }

                        resultStr += temp;
                        break;
                    }
                }
            }

            // 정답 문자열을 큐에 저장
            resultQueue.offer(code[0] + "+" + code[1] + "=" + resultStr);
        }

        while (!resultQueue.isEmpty()) {
            bw.write(resultQueue.poll() + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}