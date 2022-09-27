package BackJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Switch {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int switchCount = Integer.parseInt(br.readLine());
        String[] switchArray = br.readLine().split(" ");

        int studentCount = Integer.parseInt(br.readLine());

        for(int i = 0; i < studentCount; i++){

            String[] codeArray = br.readLine().split(" ");

            int switchNumber = Integer.parseInt(codeArray[1]);

            // 남학생일 경우 받은 번호의 배수 인덱스 스위치 상태 변경
            if(codeArray[0].equals("1")){
                
                for(int index = 1; ; index++){

                    int arrayIndex = (switchNumber*index)-1;

                    if(arrayIndex <= switchArray.length-1){
                        if(switchArray[arrayIndex].equals("1")){
                            switchArray[arrayIndex] = "0";
                        }
                        else{
                            switchArray[arrayIndex] = "1";
                        }
                    }
                    else break;
                }
            }
            // 여학생일 경우 받은 번호 기준 앞뒤 대칭으로 스위치 상태가 같은 경우 스위치 상태 변경
            else if(codeArray[0].equals("2")){

                int arrayIndex = switchNumber-1;

                if(switchArray[arrayIndex].equals("1")){
                    switchArray[arrayIndex] = "0";
                }
                else{
                    switchArray[arrayIndex] = "1";
                }

                for(int index = 1; ; index++){

                    if(arrayIndex-index >= 0 && arrayIndex+index <= switchArray.length-1){
                        if(switchArray[arrayIndex-index].equals(switchArray[arrayIndex+index])){
                            if(switchArray[arrayIndex-index].equals("1")){
                                switchArray[arrayIndex-index] = "0";
                                switchArray[arrayIndex+index] = "0";
                            }
                            else{
                                switchArray[arrayIndex-index] = "1";
                                switchArray[arrayIndex+index] = "1";
                            }
                        }
                        else break;
                    }
                    else break;
                }
            }
        }

        for(int index = 0; index < switchArray.length; index++){
            if((index)%20 == 0 && index > 0) bw.write("\n");
            bw.write(switchArray[index] + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
