package BackJoonGreedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;

public class BeerFestival {
    public static void main(String[] args) throws IOException {
        new BeerFestival().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        long m = Long.parseLong(input[1]);
        int k = Integer.parseInt(input[2]);
        Beer[] beers = new Beer[k];

        for (int i = 0; i < k; i++) {
            input = br.readLine().split(" ");
            int prefer = Integer.parseInt(input[0]);
            int alchol = Integer.parseInt(input[1]);

            Beer beer = new Beer(prefer, alchol);
            beers[i] = beer;
        }

        Arrays.sort(beers); // 도수 기준 오름차순 정렬
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(); // 선호도 기준 오름차순 정렬 큐

        long total = 0;
        int result = 0;
        for (int i = 0; i < beers.length; i++) {

            priorityQueue.offer(beers[i].prefer);
            total += beers[i].prefer;

            if (priorityQueue.size() > n) {
                total -= priorityQueue.poll();
            }

            if (priorityQueue.size() == n && total >= m) {
                result = beers[i].alchol;
                break;
            }
        }

        if (result == 0) {
            bw.write(-1 + "\n");
        } else {
            bw.write(result + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

class Beer implements Comparable<Beer> {
    int prefer;
    int alchol;

    public Beer(int prefer, int alchol) {
        this.prefer = prefer;
        this.alchol = alchol;
    }

    @Override
    public int compareTo(Beer arg0) {
        return this.alchol - arg0.alchol;
    }
}