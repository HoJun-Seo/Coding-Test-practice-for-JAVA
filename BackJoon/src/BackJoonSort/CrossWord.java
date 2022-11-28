package BackJoonSort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CrossWord {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputArray = br.readLine().split(" ");
        int r = Integer.parseInt(inputArray[0]);
        int c = Integer.parseInt(inputArray[1]);

        char[][] crossWord = new char[r][c];

        for(int i = 0; i < r; i++){
            char[] lineStr = br.readLine().toCharArray();
            
            crossWord[i] = lineStr;
        }

        // List 에 길이가 2이상으로 구성되는 문자열을 받은 다음
        // 해당 List 를 배열로 변환시킨후 Arrays.sort 를 통해 정렬

        List<String> strList = new ArrayList<>();
        // 가로 문자열 추출
        for(int i = 0; i < r; i++){
            String str = "";
            for(int j = 0; j < c; j++){

                // 중간에 #을 만나지 않을 경우
                if(crossWord[i][j] != '#'){
                    str += crossWord[i][j];
                }
                // # 을 만났을 경우
                else{
                    if(str.length() == 1){
                        str = "";
                    }
                    else if(str.length() > 1){
                        strList.add(str);
                        str = "";
                    }
                }
            }

            // 반복문이 끝난 이후 str 에 내용이 남아있을 경우 List 에 추가
            if(!str.equals("") && str.length() > 1){
                strList.add(str);
            }
        }

        // 세로 문자열 추출
        for(int j = 0; j < c; j++){
            String str = "";
            for(int i = 0; i < r; i++){
                if(crossWord[i][j] != '#'){
                    str += crossWord[i][j];
                }
                else{
                    if(str.length() == 1){
                        str = "";
                    }
                    else if(str.length() > 1){
                        strList.add(str);
                        str = "";
                    }
                }
            }

            if(!str.equals("") && str.length() > 1){
                strList.add(str);
            }
        }

        Collections.sort(strList);
        bw.write(strList.get(0) + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}