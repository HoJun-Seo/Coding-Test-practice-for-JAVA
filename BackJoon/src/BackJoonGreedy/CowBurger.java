package BackJoonGreedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;

public class CowBurger {
    public static void main(String[] args) throws IOException {
        new CowBurger().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int[] count = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            count[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(count);
        int menuCount = count[0];

        Integer[] burger = new Integer[Integer.parseInt(input[0])];
        Integer[] side = new Integer[Integer.parseInt(input[1])];
        Integer[] drink = new Integer[Integer.parseInt(input[2])];

        input = br.readLine().split(" ");
        for (int i = 0; i < burger.length; i++) {
            burger[i] = Integer.parseInt(input[i]);
        }
        input = br.readLine().split(" ");
        for (int i = 0; i < side.length; i++) {
            side[i] = Integer.parseInt(input[i]);
        }

        input = br.readLine().split(" ");
        for (int i = 0; i < drink.length; i++) {
            drink[i] = Integer.parseInt(input[i]);
        }

        int before = Arrays.stream(burger).reduce(0, (a, b) -> a + b) +
                Arrays.stream(side).reduce(0, (a, b) -> a + b) +
                Arrays.stream(drink).reduce(0, (a, b) -> a + b);

        Arrays.sort(burger, Collections.reverseOrder());
        Arrays.sort(side, Collections.reverseOrder());
        Arrays.sort(drink, Collections.reverseOrder());

        int result = 0;
        int i = 0;
        for (; i < menuCount; i++) {
            int sum = (int) ((burger[i] + side[i] + drink[i]) * 0.9);
            result += sum;
        }
        int index = i;
        if (i < burger.length) {
            index = i;
            for (; index < burger.length; index++) {
                result += burger[index];
            }
        }
        if (i < side.length) {
            index = i;
            for (; index < side.length; index++) {
                result += side[index];
            }
        }
        if (i < drink.length) {
            index = i;
            for (; index < drink.length; index++) {
                result += drink[index];
            }
        }

        bw.write(before + "\n" + result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}