package BackJoonGreedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class SnakeBird {
    public static void main(String[] args) throws IOException {
        new SnakeBird().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int count = Integer.parseInt(input[0]);
        int size = Integer.parseInt(input[1]);
        int[] fruits = new int[count];
        input = br.readLine().split(" ");
        for (int i = 0; i < fruits.length; i++) {
            fruits[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(fruits);

        for (int i = 0; i < fruits.length; i++) {
            if (fruits[i] <= size) {
                size++;
            } else
                break;
        }

        bw.write(size + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}