package BackJoonString;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MakeWord {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<String> dictionary = new ArrayList<>();
        Queue<String> puzzleQueue = new LinkedList<>();

        while (true) {

            String input = br.readLine();
            if (input.equals("-"))
                break;

            dictionary.add(input);
        }

        String[] dictionaryArray = dictionary.toArray(new String[dictionary.size()]);

        while (true) {
            String input = br.readLine();
            if (input.equals("#"))
                break;

            puzzleQueue.offer(input);
        }

        // 퍼즐에 똑같은 글자가 있는 경우 같은 탐색을 중복하게 되므로 이를 방지하기 위해 해시맵을 사용하자.
        // 1. 특정한 글자를 포함하고 있는지 살핀다.
        // 2. 특정한 글자를 포함하고 있는 경우, 퍼즐에 있는 단어를 중복 사용하지 않고 해당 단어를 만들수 있는지 확인한다.
        // 3. 만들수 있는 경우 해당 글자에서의 카운트를 늘린다.
        // 4. 위와 같은 방식으로 사전에 있는 모든 단어들을 확인한다.
        // 5. 퍼즐에 있는 모든 글자 하나하나씩(중복되지 않게) 위 과정을 수행한다.

        while (!puzzleQueue.isEmpty()) {
            String str = puzzleQueue.poll();
            List<String> puzzle = new ArrayList<>();

            for (int i = 0; i < str.length(); i++) {
                puzzle.add(String.valueOf(str.charAt(i)));
            }

            HashMap<String, Integer> checkHashMap = new HashMap<>();

            for (int i = 0; i < puzzle.size(); i++) {
                String center = puzzle.get(i);
                checkHashMap.put(center, 0); // 이러면 중복된 글자는 전부다 0 부터 시작함

                for (int j = 0; j < dictionaryArray.length; j++) {
                    String word = dictionaryArray[j];

                    if (word.contains(center)) {
                        // 특정 글자를 포함하고 있는 경우 그 퍼즐안에 있는 다른 글자들로 해당 단어를 만들수 있는지 확인
                        // 일단 필수로 포함되는 글자 하나부터 먼저 날리고 시작
                        word = word.replaceFirst(center, "");
                        for (int x = 0; x < puzzle.size(); x++) {
                            if (x == i) // 퍼즐 중앙에 있던(필수로 포함되는) 글자는 이미 제거되었음
                                continue;
                            else {
                                if (word.contains(puzzle.get(x))) {
                                    word = word.replaceFirst(puzzle.get(x), "");
                                }

                                if (word.equals("")) {
                                    break;
                                }
                            }
                        }

                        if (word.equals("")) {
                            // 특정 글자를 필수로 포함시켰을 때 단어 완성이 가능한 경우
                            int value = checkHashMap.get(center);
                            value++;
                            checkHashMap.put(center, value);
                        }
                    }
                }
            }

            // 퍼즐에 있는 모든 글자 하나하나를 중앙에 위치 시켰을 때 만들수 있는 단어 갯수 계산 끝
            // 가장 쉬운경우, 가장 어려운 경우를 정답으로 출력

            String minKey = "";
            String maxKey = "";
            int minValue = Integer.MAX_VALUE;
            int maxValue = Integer.MIN_VALUE;

            Object[] keyArray = checkHashMap.keySet().toArray();
            Arrays.sort(keyArray);
            for (int i = 0; i < keyArray.length; i++) {

                int value = checkHashMap.get(keyArray[i]);
                if (value == minValue) {
                    minKey += (String) keyArray[i];
                } else if (value < minValue) {
                    minValue = value;
                    minKey = (String) keyArray[i];
                }

                if (value == maxValue) {
                    maxKey += (String) keyArray[i];
                } else if (value > maxValue) {
                    maxValue = value;
                    maxKey = (String) keyArray[i];
                }
            }

            bw.write(minKey + " " + minValue + " " + maxKey + " " + maxValue + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}