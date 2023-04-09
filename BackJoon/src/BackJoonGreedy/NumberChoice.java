package BackJoonGreedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class NumberChoice {
    public static void main(String[] args) throws IOException {
        new NumberChoice().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int size = Integer.parseInt(input[0]);
        int count = Integer.parseInt(input[1]);

        Number[] numberArray = new Number[size];
        Queue<Number> queue = new LinkedList<>();

        input = br.readLine().split(" ");
        for (int i = 0; i < input.length; i++) {
            Number number = new Number(i, Integer.parseInt(input[i]));
            numberArray[i] = number;
        }
        Number[] cloneArray = numberArray.clone();
        Arrays.sort(numberArray);
        for (int i = 0; i < count; i++) {
            queue.offer(numberArray[i]);
        }

        int[] indexArray = new int[count];
        for (int i = 0; i < indexArray.length; i++) {
            indexArray[i] = queue.poll().index;
        }
        Arrays.sort(indexArray);
        int result = 0;
        for (int i = 0; i < indexArray.length; i++) {
            result += (cloneArray[indexArray[i]].value - i);
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }
}

class Number implements Comparable<Number> {
    int index;
    int value;

    public Number(int index, int value) {
        this.index = index;
        this.value = value;
    }

    @Override
    public int compareTo(Number arg0) {
        return arg0.value - this.value;
    }
}