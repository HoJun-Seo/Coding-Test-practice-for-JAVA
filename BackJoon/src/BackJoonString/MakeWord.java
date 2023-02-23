package BackJoonString;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;

public class MakeWord {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] dictionaryArray = new String[200001];

        for (int i = 0; i < dictionaryArray.length; i++) {

            String input = br.readLine();
            if (input.equals("-"))
                break;

            dictionaryArray[i] = input;
        }

        // 사전에 있는 단어와 퍼즐에 있는 글자들의 알파벳이 몇번 나왔는지 비교
        // 퍼즐에 있는 글자로 사전에 있는 단어를 만들수 있는 경우
        // 퍼즐의 글자들중 해당 단어를 구성할 수 있는 글자에 카운트 1씩 추가
        // 해시맵을 쓰는게 편할듯?

        while (true) {

            String input = br.readLine();
            int index = 0;
            if (input.equals("#"))
                break;
            else {

                HashMap<Character, Integer> puzzleMap = new HashMap<>();
                for (int i = 0; i < input.length(); i++) {
                    char ch = input.charAt(i);
                    puzzleMap.put(ch, 0);
                }

                while (true) {
                    HashMap<Character, Integer> alphabetMap = new HashMap<>();
                    String word = dictionaryArray[index];
                    if (word == null)
                        break;
                    else {

                        // 반복문을 돌면서 단어에 어떤 알파벳이 몇번씩 나왔는지 확인
                        for (int i = 0; i < word.length(); i++) {
                            char ch = word.charAt(i);

                            if (alphabetMap.containsKey(ch)) {
                                int value = alphabetMap.get(ch);
                                value++;
                                alphabetMap.put(ch, value);
                            } else {
                                alphabetMap.put(ch, 1);
                            }
                        }

                        // 퍼즐에 있는 글자로 단어를 완성할 수 있는지 확인
                        for (int i = 0; i < input.length(); i++) {
                            char ch = input.charAt(i);

                            if (alphabetMap.containsKey(ch)) {
                                int value = alphabetMap.get(ch);
                                value--;
                                alphabetMap.put(ch, value);
                            }
                        }

                        boolean check = true;
                        Object[] keyArray = alphabetMap.keySet().toArray();
                        for (int i = 0; i < keyArray.length; i++) {
                            int value = alphabetMap.get((Character) keyArray[i]);

                            if (value > 0) {
                                check = false;
                                break;
                            }
                        }

                        // 퍼즐에 있는 글자로 단어를 만들수 있는 경우
                        if (check) {
                            for (int i = 0; i < keyArray.length; i++) {
                                char ch = (Character) keyArray[i];

                                int value = puzzleMap.get(ch);
                                value++;
                                puzzleMap.put(ch, value);
                            }
                        }

                        index++;
                    }
                }

                // 퍼즐의 글자들 중에서 value 가 가장 작은값, 가장 큰값 순서대로 출력
                Object[] keyArray = puzzleMap.keySet().toArray();
                Arrays.sort(keyArray);

                int minValue = Integer.MAX_VALUE;
                int maxValue = Integer.MIN_VALUE;

                String minKey = "";
                String maxKey = "";
                for (int i = 0; i < keyArray.length; i++) {

                    int value = puzzleMap.get(keyArray[i]);

                    if (value == minValue) {
                        minKey += String.valueOf(keyArray[i]);
                        minValue = value;
                    } else if (value < minValue) {
                        minKey = String.valueOf(keyArray[i]);
                        minValue = value;
                    }

                    if (value == maxValue) {
                        maxKey += String.valueOf(keyArray[i]);
                        maxValue = value;
                    } else if (value > maxValue) {
                        maxKey = String.valueOf(keyArray[i]);
                        maxValue = value;
                    }
                }

                bw.write(minKey + " " + minValue + " " + maxKey + " " + maxValue + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}