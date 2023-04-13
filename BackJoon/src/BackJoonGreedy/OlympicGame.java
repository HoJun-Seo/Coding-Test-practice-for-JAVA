package BackJoonGreedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;

public class OlympicGame {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new OlympicGame().solution();
    }

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        int[] resultArray = new int[count];
        for (int i = 0; i < count; i++) {
            int gameCount = Integer.parseInt(br.readLine());
            int result = 0;
            Game[] gameArray = new Game[gameCount];
            for (int j = 0; j < gameCount; j++) {
                String[] input = br.readLine().split(" ");

                int day = Integer.parseInt(input[0]);
                int start = Integer.parseInt(input[1]);
                int end = Integer.parseInt(input[2]);

                Game game = new Game(day, start, end);
                gameArray[j] = game;
            }

            Arrays.sort(gameArray);

            Stack<Game> gameStack = new Stack<>();
            for (int j = gameArray.length - 1; j >= 0; j--) {
                if (gameStack.isEmpty()) {
                    gameStack.push(gameArray[j]);
                } else {
                    Game after = gameStack.peek();
                    Game before = gameArray[j];

                    if (after.day > before.day) {
                        gameStack.push(before);
                    } else {
                        if (after.start >= before.end) {
                            gameStack.push(before);
                        }
                    }
                }
            }

            result = gameStack.size();
            resultArray[i] = result;
        }

        int number = 1;
        for (int i : resultArray) {
            bw.write("Scenario #" + number + ":\n" + i + "\n\n");
            number++;
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

class Game implements Comparable<Game> {
    int day;
    int start;
    int end;

    public Game(int day, int start, int end) {
        this.day = day;
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Game arg0) {
        if (this.day == arg0.day) {
            if (this.start == arg0.start) {
                return this.end - arg0.end;
            } else {
                return this.start - arg0.start;
            }
        } else {
            return this.day - arg0.day;
        }
    }
}