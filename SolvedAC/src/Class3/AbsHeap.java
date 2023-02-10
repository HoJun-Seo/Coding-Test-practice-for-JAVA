package Class3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class AbsHeap {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Data> prior = new PriorityQueue<>();

        int orderSize = Integer.parseInt(br.readLine());
        int[] orderArray = new int[orderSize];

        // 명령 입력
        for (int i = 0; i < orderArray.length; i++) {
            orderArray[i] = Integer.parseInt(br.readLine());
        }

        // 명령 수행
        for (int i = 0; i < orderArray.length; i++) {
            // 0이면 출력
            // 0 이외의 다른 숫자라면 삽입
            if (orderArray[i] == 0) {
                if (prior.isEmpty()) {
                    bw.write(0 + "\n");
                } else {
                    bw.write(prior.poll().origin + "\n");
                }
            } else {
                prior.offer(new Data(orderArray[i]));
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

class Data implements Comparable<Data> {
    int origin;
    int absValue;

    public Data(int origin) {
        this.origin = origin;
        this.absValue = Math.abs(this.origin);
    }

    @Override
    public int compareTo(Data o) {
        if (this.absValue > o.absValue) {
            return 1;
        } else if (this.absValue == o.absValue) {
            if (this.origin > o.origin) {
                return 1;
            } else
                return -1;
        } else
            return -1;
    }
}