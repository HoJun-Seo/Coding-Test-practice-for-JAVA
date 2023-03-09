package BackJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class JungMin {
    public static void main(String[] args) throws IOException {
        new JungMin().solution();
    }

    private void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] array = br.readLine().split(" ");

        BigInteger result = new BigInteger("0");
        for (int i = 0; i < array.length; i++) {
            result = result.add(new BigInteger(array[i]));
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}