package BackJoonGreedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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

        long max = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            input = br.readLine().split(" ");
            int prefer = Integer.parseInt(input[0]);
            int alchol = Integer.parseInt(input[1]);

            Beer beer = new Beer(prefer, alchol);
            beers[i] = beer;

            max = Math.max(max, alchol);
        }

        long start = 1;
        long end = max;
        Arrays.sort(beers);

        long result = Integer.MAX_VALUE;
        while (start <= end) {
            long mid = (start + end) / 2;

            List<Integer> preferList = new ArrayList<>();
            for (int i = 0; i < beers.length; i++) {
                if (beers[i].alchol > mid)
                    break;
                else
                    preferList.add(beers[i].prefer);
            }
            if (preferList.size() < n) {
                start = mid + 1;
            } else {

                Collections.sort(preferList, Collections.reverseOrder());
                long total = 0;
                for (int i = 0; i < n; i++) {
                    total += preferList.get(i);
                }

                if (total < m) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                    result = Math.min(result, mid);
                }
            }

        }

        if (result == Integer.MAX_VALUE) {
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