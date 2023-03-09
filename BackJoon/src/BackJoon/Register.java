package BackJoon;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Register {
    public static void main(String[] args) throws IOException {
        new Register().solution();
    }

    private void solution() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(227 + "\n");
        bw.write("ghwns6659\n");
        bw.flush();
        bw.close();
    }
}
