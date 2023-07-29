package BackJoonGraph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Spica {
    public static void main(String[] args) throws IOException {
        new Spica().solution();
    }

    static HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
    static boolean[] visited = new boolean[13];

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 12; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            List<Integer> aList = new ArrayList<>();
            List<Integer> bList = new ArrayList<>();
            if (hashMap.containsKey(a)) {
                aList = hashMap.get(a);
            }
            aList.add(b);
            hashMap.put(a, aList);

            if (hashMap.containsKey(b)) {
                bList = hashMap.get(b);
            }
            bList.add(a);
            hashMap.put(b, bList);

            if (a > b) {
                min = Math.min(min, b);
            } else {
                min = Math.min(min, a);
            }
        }

        int result = bfs(min);

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private int bfs(int min) {
        Queue<Integer> needVisit = new LinkedList<>();
        needVisit.offer(min);
        visited[min] = true;

        int result = 0;
        while (!needVisit.isEmpty()) {
            int number = needVisit.poll();

            List<Integer> list = hashMap.get(number);
            // spica 인지 확인
            if (list.size() > 2) {
                boolean one = false;
                boolean two = false;
                boolean three = false;

                for (int i = 0; i < 3; i++) {
                    int connect = list.get(i);

                    if (hashMap.get(connect).size() == 3 && !three) {
                        three = true;
                    } else if (hashMap.get(connect).size() == 2 && !two) {
                        two = true;
                    } else if (hashMap.get(connect).size() == 1 && !one) {
                        one = true;
                    }
                }
                if (one && two && three) {
                    result = number;
                    break;
                }
            }
            // 방문 필요큐에 연결 노드 저장
            for (int i = 0; i < list.size(); i++) {
                if (!visited[list.get(i)]) {
                    needVisit.offer(list.get(i));
                    visited[list.get(i)] = true;
                }
            }
        }
        return result;
    }
}