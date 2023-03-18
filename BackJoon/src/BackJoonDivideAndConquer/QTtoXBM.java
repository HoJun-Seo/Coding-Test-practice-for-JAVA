package BackJoonDivideAndConquer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class QTtoXBM {

    static char[][] quadTree = null;
    static String s = null;

    public static void main(String[] args) throws NumberFormatException, IOException {
        new QTtoXBM().solution();
    }

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(br.readLine());
        s = br.readLine();

        quadTree = new char[size][size];

    }
}
