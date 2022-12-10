package Class3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Remote {

    static int[] button = new int[10];
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int goalChannel = Integer.parseInt(br.readLine());   
        int errorCount = Integer.parseInt(br.readLine());

        String[] inputArray = new String[errorCount];
        if(errorCount > 0){
            inputArray = br.readLine().split(" ");
        }
        
        for(int i = 0; i < errorCount; i++){
            button[Integer.parseInt(inputArray[i])] = 1;
        }

        int current = 100;
        int directCount = Math.abs(goalChannel - current); // +/- 로만 접근했을때 필요한 입력 횟수
        int nearCount = 0;
        // 1. 직접 입력이 가능한지 확인(직접 입력 가능하면 굳이 근사치를 찾을 필요 없음)
        if(directInput(goalChannel)){
            nearCount = String.valueOf(goalChannel).length();
        }
        else{

            int nearChannel = goalChannel;

            boolean plusChannel = true;
            boolean minusChnnel = true;
            int plusCount = Integer.MAX_VALUE;
            int minusCount = Integer.MAX_VALUE;
            
            int[] errorArray = Arrays.stream(button).filter(x -> x == 1).toArray();

            if(errorArray.length == 9 && button[0] == 0){ // 0 버튼 이외에 모든 버튼이 고장난 경우 - 더 큰 채널을 찾아가는게 불가능
                // 무조건 0번 채널에서 출발시킴
                // 0번 누르는거 한번 + 해당 채널 까지 가는데 필요한 + 입력 버튼 횟수
                plusCount = 1 + goalChannel;
            }
            else if(errorArray.length <= 9){ // 큰 채널, 작은 채널 모두 다 찾아가는것 가능

                while(plusChannel){
                    nearChannel += 1;
                    if(directInput(nearChannel)){
                        plusCount = (nearChannel - goalChannel) + String.valueOf(nearChannel).length();
                        plusChannel = false;
                    }
                }
                
                nearChannel = goalChannel;
                while(minusChnnel){
                    nearChannel -= 1;
                    if(nearChannel < 0){
                        minusChnnel = false;
                    }
                    else if(directInput(nearChannel)){
                        minusCount = (goalChannel - nearChannel) + String.valueOf(nearChannel).length();
                        minusChnnel = false;
                    }
                }
            }
            
            // 모든 버튼이 고장난 경우는 무조건 directCount 가 정답이므로 따로 채널을 직접 입력해서 찾아가는 방법을 활용하지 않음
            if(plusCount < minusCount){
                nearCount = plusCount;
            }
            else if(minusCount < plusCount){
                nearCount = minusCount;
            }
            else if(minusCount == plusCount){
                nearCount = plusCount;
            }
        }

        int result = 0;
        if(directCount < nearCount){
            result = directCount;
        }
        else if(directCount > nearCount){
            result = nearCount;
        }
        else if(directCount == nearCount){
            result = directCount;
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    // 고장나지 않은 버튼으로 직접 입력 가능한지 판단
    private static boolean directInput(int goalChannel) {

        String goal = String.valueOf(goalChannel);

        boolean check = true;
        for(int i = 0; i < goal.length(); i++){
            char ch = goal.charAt(i);
            int index = Character.getNumericValue(ch);

            if(button[index] == 1){
                check = false;
                break;
            }
        }
        
        if(check){
            return true;
        }
        else{
            return false;
        }
    }
}