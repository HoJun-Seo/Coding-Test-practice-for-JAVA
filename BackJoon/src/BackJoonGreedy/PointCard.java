package BackJoonGreedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class PointCard {
    public static void main(String[] args) throws IOException {
        new PointCard().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        Card[] array = new Card[m];

        for(int i = 0; i < m; i++){
            input = br.readLine().split(" ");

            int success = Integer.parseInt(input[0]);
            int fail = Integer.parseInt(input[1]);

            Card card = new Card(success, fail);
            array[i] = card;
        }

        Arrays.sort(array);

        int count = 0;
        int money = 0;
        for(int i = 0; i < m; i++){

            Card card = array[i];

            if(card.success < n){
                money += (n - card.success);
            }
            count++;

            if(count == m - 1) 
                break;
        }

        bw.write(money + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

class Card implements Comparable<Card>{
    int success;
    int fail;

    public Card(int success, int fail){
        this.success = success;
        this.fail = fail;
    }
    @Override
    public int compareTo(Card o) {
        return o.success - this.success;
    }
}