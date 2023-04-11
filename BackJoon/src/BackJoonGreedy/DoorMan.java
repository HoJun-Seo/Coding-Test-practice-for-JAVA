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
        while (Math.abs(manCount - womanCount) <= x && !people.isEmpty()) {
            char ch = people.pollFirst();

            if (ch == 'M') {
                // 현재 남자가 더 많아서 남자를 더 받으면 차이가 늘어나는 경우
                if (manCount > womanCount) {
                    // 두번째 사람 확인
                    if (people.size() > 0) {
                        if (people.peekFirst() == 'W') {
                            // 두번째 사람이 여자인 경우 두번째 사람 먼저 입장
                            womanCount++;
                            people.pollFirst();
                            people.offerFirst(ch);
                            if (Math.abs(manCount - womanCount) > x) {
                                womanCount--;
                                break;
                            }
                        } else {
                            // 두번째 사람도 남자인 경우 그냥 첫번째 사람 입장
                            manCount++;
                            if (Math.abs(manCount - womanCount) > x) {
                                manCount--;
                                break;
                            }
                        }
                    } else {
                        // 두번째 사람까지 확인이 불가능한 경우
                        manCount++;
                        if (Math.abs(manCount - womanCount) > x) {
                            manCount--;
                            break;
                        }
                    }
                } else {
                    // 여자가 더 많거나 같은 경우
                    manCount++;
                    if (Math.abs(manCount - womanCount) > x) {
                        manCount--;
                        break;
                    }
                }
            } else if (ch == 'W') {
                if (womanCount > manCount) {
                    if (people.size() > 0) {
                        if (people.peekFirst() == 'M') {
                            manCount++;
                            people.pollFirst();
                            people.offerFirst(ch);
                            if (Math.abs(manCount - womanCount) > x) {
                                manCount--;
                                break;
                            }
                        } else {
                            womanCount++;
                            if (Math.abs(manCount - womanCount) > x) {
                                womanCount--;
                                break;
                            }
                        }
                    } else {
                        womanCount++;
                        if (Math.abs(manCount - womanCount) > x) {
                            womanCount--;
                            break;
                        }
                    }

                } else {
                    womanCount++;
                    if (Math.abs(manCount - womanCount) > x) {
                        womanCount--;
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