package BackJoonGreedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;

public class Octopus {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new Octopus().solution();
    }

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        int[] result = new int[count + 1];
        Deque<Octo> deque = new LinkedList<>();

        for (int i = 0; i < count; i++) {
            int[] hands = new int[9];
            Octo octo = new Octo(hands);
            if (i == 0 && deque.isEmpty()) {
                deque.push(octo);
            }

            else if (i < count && !deque.isEmpty()) {
                Octo beforeOcto = deque.pop();
                for (int index = 1; index < beforeOcto.hands.length; index++) {
                    if (beforeOcto.hands[index] == 0) {
                        beforeOcto.hands[index] = 1;
                        octo.hands[index] = 1;

                        deque.push(beforeOcto);
                        deque.push(octo);

                        result[i] = index;

                        break;
                    }
                }
            }
        }

        Octo beforOcto = deque.peekFirst();
        Octo octo = deque.peekLast();
        for (int index = 1; index < beforOcto.hands.length; index++) {
            if (beforOcto.hands[index] == 0 && octo.hands[index] == 0) {
                beforOcto.hands[index] = 1;
                octo.hands[index] = 1;

                result[count] = index;
                break;
            }
        }

        for (int i = 1; i < result.length; i++) {
            bw.write(result[i] + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

class Octo {
    int[] hands;

    public Octo(int[] hands) {
        this.hands = hands;
    }
}