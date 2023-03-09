package BackJoonString;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class StringSign {
    public static void main(String[] args) throws IOException {
        new StringSign().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        BigInteger x = new BigInteger(input[0]);
        BigInteger y = new BigInteger(input[1]);

        BigInteger result = (x.add(y)).multiply((x.subtract(y)));
        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
