package BackJoonGreedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;

public class DoorMan {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new DoorMan().solution();
    }

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int x = Integer.parseInt(br.readLine());
        String str = br.readLine();
        Deque<Character> people = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            people.offerLast(str.charAt(i));
        }

        int manCount = 0;
        int womanCount = 0;
        char firstGender = ' ';
        char secondGender = ' ';
        while (Math.abs(manCount - womanCount) <= x && !people.isEmpty()) {
            firstGender = people.pollFirst();

            if (firstGender == 'M') {
                if (Math.abs((manCount + 1) - womanCount) <= x) {
                    manCount++;
                } else {
                    if (!people.isEmpty()) {
                        secondGender = people.pollFirst();
                        if (secondGender == 'W') {
                            womanCount++;
                            people.offerFirst(firstGender);
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                }
            } else if (firstGender == 'W') {
                if (Math.abs(manCount - (womanCount + 1)) <= x) {
                    womanCount++;
                } else {
                    if (!people.isEmpty()) {
                        secondGender = people.pollFirst();
                        if (secondGender == 'M') {
                            manCount++;
                            people.offerFirst(firstGender);
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }

                }
            }
        }
        bw.write((manCount + womanCount) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}