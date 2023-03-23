package BackJoonGreedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class RSP {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new RSP().solution();
    }

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int round = Integer.parseInt(br.readLine());
        int[] scoreArray = new int[round];
        char[] sangkun = br.readLine().toCharArray();
        int firstResult = 0;
        int secondResult = 0;

        int friendCount = Integer.parseInt(br.readLine());
        String[] friend = new String[friendCount];
        // 1. 처음에 주어진 상근이가 낸 모양을 바탕으로 점수계산
        for (int i = 0; i < friend.length; i++) {
            friend[i] = br.readLine();
            char[] friendRSP = friend[i].toCharArray();

            for (int index = 0; index < round; index++) {
                if (sangkun[index] == 'R') {
                    if (friendRSP[index] == 'R') {
                        firstResult += 1;
                    } else if (friendRSP[index] == 'S') {
                        firstResult += 2;
                    }
                } else if (sangkun[index] == 'S') {
                    if (friendRSP[index] == 'S') {
                        firstResult += 1;
                    } else if (friendRSP[index] == 'P') {
                        firstResult += 2;
                    }
                } else if (sangkun[index] == 'P') {
                    if (friendRSP[index] == 'P') {
                        firstResult += 1;
                    } else if (friendRSP[index] == 'R') {
                        firstResult += 2;
                    }
                }
            }
        }

        bw.write(firstResult + "\n");
        // 2. 친구들이 낸 모양을 보고 각 라운드별로 가장 승리가 많은 경우를 계산 한 뒤 합산
        // 각 라운드에서 어떠 한 모양을 냈을때 점수가 얼마나 나오는지 계산한다.(브루트포스)
        // 가장 많은 승점을 딸 수 있는 경우를 뽑아내어 합산한다.

        for (int i = 0; i < round; i++) {
            char[] rsp = { 'R', 'S', 'P' };
            int roundscore = 0;
            for (int j = 0; j < rsp.length; j++) {
                int score = 0;

                for (int index = 0; index < friend.length; index++) {
                    char friendPresent = friend[index].charAt(i);
                    char sk = rsp[j];

                    if (sk == 'R') {
                        if (friendPresent == 'R') {
                            score += 1;
                        } else if (friendPresent == 'S') {
                            score += 2;
                        }
                    } else if (sk == 'S') {
                        if (friendPresent == 'S') {
                            score += 1;
                        } else if (friendPresent == 'P') {
                            score += 2;
                        }
                    } else if (sk == 'P') {
                        if (friendPresent == 'P') {
                            score += 1;
                        } else if (friendPresent == 'R') {
                            score += 2;
                        }
                    }
                }

                roundscore = Math.max(roundscore, score);
            }

            secondResult += roundscore;
        }

        bw.write(secondResult + "\n");

        bw.flush();
        bw.close();
        br.close();

    }
}