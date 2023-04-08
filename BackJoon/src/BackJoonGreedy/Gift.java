package BackJoonGreedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Gift {
    public static void main(String[] args) throws IOException {
        new Gift().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int count = Integer.parseInt(input[0]);
        int money = Integer.parseInt(input[1]);

        Friend[] friends = new Friend[count];
        for (int i = 0; i < count; i++) {
            input = br.readLine().split(" ");
            int price = Integer.parseInt(input[0]);
            int transportPrice = Integer.parseInt(input[1]);

            Friend friend = new Friend(price, transportPrice);
            friends[i] = friend;
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < count; i++) {
            int[] totalArray = new int[count];
            for (int j = 0; j < totalArray.length; j++) {
                if (i == j) {
                    totalArray[j] = (friends[j].price / 2) + friends[j].transportPrice;
                } else {
                    totalArray[j] = friends[j].price + friends[j].transportPrice;
                }
            }

            Arrays.sort(totalArray);
            long sum = 0;
            int success = 0;
            for (int j = 0; j < totalArray.length; j++) {

                sum += totalArray[j];
                if (sum > money) {
                    break;
                } else {
                    success++;
                }
            }
            max = Math.max(max, success);
        }

        bw.write(max + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

class Friend {
    int price;
    int transportPrice;

    public Friend(int price, int transportPrice) {
        this.price = price;
        this.transportPrice = transportPrice;
    }
}