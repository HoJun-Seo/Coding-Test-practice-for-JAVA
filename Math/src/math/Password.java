package math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Password {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int col = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int line = str.length()/col;

        char [][] pwArray = new char[line][col];
        int index = 0;

        for(int i = 0; i < line; i++){

            // 현재 행이 짝수일 경우 정방향
            if(i % 2 == 0){
                for(int j = 0; j < col; j++){
                    pwArray[i][j] = str.charAt(index);
                    index++;
                }
            }
            // 현재 행이 홀수일 경우 역방향
            else if(i % 2 != 0){
                for(int j = col-1; j >= 0; j--){
                    pwArray[i][j] = str.charAt(index);
                    index++;
                }
            }
        }

        for(int j = 0; j < col; j++){
            for(int i = 0; i < line; i++){
                bw.write(pwArray[i][j]);
            }
        }
        bw.write("\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
