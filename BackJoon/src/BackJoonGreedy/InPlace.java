package BackJoonGreedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class InPlace {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new InPlace().solution();
    }

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(br.readLine());
        String[] input = new String[size];
        input = br.readLine().split(" ");
        Queue<String> queue = new LinkedList<>();

        int number = 1;
        for (int i = 0; i < input.length; i++) {
            if (number == Integer.parseInt(input[i])) {
                queue.offer(input[i]);
                number++;
            }
        }

        int result = input.length - queue.size();
        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}