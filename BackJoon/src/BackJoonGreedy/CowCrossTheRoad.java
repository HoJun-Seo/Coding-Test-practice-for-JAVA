package BackJoonGreedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class CowCrossTheRoad {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new CowCrossTheRoad().solution();
    }

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());

        Cow[] cowArray = new Cow[count];
        for (int i = 0; i < count; i++) {
            String[] input = br.readLine().split(" ");
            int arrive = Integer.parseInt(input[0]);
            int time = Integer.parseInt(input[1]);

            cowArray[i] = new Cow(arrive, time);
        }

        Arrays.sort(cowArray);
        long result = 0;

        for (int i = 0; i < cowArray.length; i++) {
            if (result >= cowArray[i].arrive) {
                result += cowArray[i].time;
            } else if (result < cowArray[i].arrive) {
                result = cowArray[i].arrive + cowArray[i].time;
            }
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

class Cow implements Comparable<Cow> {
    int arrive;
    int time;

    public Cow(int arrive, int time) {
        this.arrive = arrive;
        this.time = time;
    }

    @Override
    public int compareTo(Cow arg0) {
        if (this.arrive == arg0.arrive) {
            return this.time - arg0.time;
        } else {
            return this.arrive - arg0.arrive;
        }
    }
}