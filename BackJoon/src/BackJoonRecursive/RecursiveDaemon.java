package BackJoonRecursive;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class RecursiveDaemon {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new RecursiveDaemon().solution();
    }

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++) {
            String str = br.readLine();

            Palin palin = isPalindrome(str);
            bw.write(palin.result + " " + palin.count + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static Palin recursion(String s, int l, int r, int count) {
        if (l >= r)
            return new Palin(1, count);
        else if (s.charAt(l) != s.charAt(r))
            return new Palin(0, count);
        else
            return recursion(s, l + 1, r - 1, count + 1);
    }

    public static Palin isPalindrome(String s) {
        return recursion(s, 0, s.length() - 1, 1);
    }
}

class Palin {
    int result;
    int count;

    public Palin(int result, int count) {
        this.result = result;
        this.count = count;
    }
}