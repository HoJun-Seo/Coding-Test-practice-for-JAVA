package Class3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class DSLR {

    static boolean[] visited;
    static Register[] registerArray;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        registerArray = new Register[count];

        for(int i = 0; i < count; i++){
            String[] inputArray = br.readLine().split(" ");

            int A = Integer.parseInt(inputArray[0]);
            int B = Integer.parseInt(inputArray[1]);
            Register register = new Register(A, B, A);

            registerArray[i] = register;
        }

        for(int i = 0; i < registerArray.length; i++){

            registerArray[i].command = bfs(i);
        }

        for(int i = 0; i < registerArray.length; i++){
            bw.write(registerArray[i].command + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
        
    }
    private static String bfs(int i) {
        Queue<Register> queue = new LinkedList<>();
        visited = new boolean[10000];
        visited[registerArray[i].curNumber] = true;
        queue.offer(registerArray[i]);

        String result = "";

        while(!queue.isEmpty()){
            Register register = queue.poll();

            if(register.curNumber == register.B){
                result = register.command;
                break;
            }
            else{
                // 현재 레지스터 숫자에 각 명령어 실행

                // 본래 객체값을 유지한 채 각 조건문을 수행해야 한다.
                // 그러므로 객체를 완전히 새로 만들어서 큐에 삽입한다.
                int numberD = register.commandD();
                int numberS = register.commandS();
                int numberL = register.commandL();
                int numberR = register.commandR();
                // D
                if(!visited[numberD]){
                    Register numberChange = new Register(register.A, register.B, numberD);
                    numberChange.command = register.command + "D";
                    queue.offer(numberChange);
                    visited[numberD] = true;
                }
                // S
                if(!visited[numberS]){
                    Register numberChange = new Register(register.A, register.B, numberS);
                    numberChange.command = register.command + "S";
                    queue.offer(numberChange);
                    visited[numberS] = true;
                }
                // L
                if(!visited[numberL]){
                    Register numberChange = new Register(register.A, register.B, numberL);
                    numberChange.command = register.command + "L";
                    queue.offer(numberChange);
                    visited[numberL] = true;
                }
                // R
                if(!visited[numberR]){
                    Register numberChange = new Register(register.A, register.B, numberR);
                    numberChange.command = register.command + "R";
                    queue.offer(numberChange);
                    visited[numberR] = true;
                }
            }
        }

        return result;
    }
}

class Register {
    int A;
    int B;

    int curNumber;
    String command;

    public Register(int A, int B, int curNumber){
        this.A = A;
        this.B = B;
        this.curNumber = curNumber;
        this.command = "";
    }

    public int commandD(){
        int number = this.curNumber * 2;
        if(number > 9999) number = number % 10000;
        return number;
    }

    public int commandS(){
        int number = 0;
        if(this.curNumber == 0){
            number = 9999;
        }
        else{
            number = this.curNumber - 1;
        }
        return number;
    }

    public int commandL(){

        String numString = changeString(this.curNumber);
        char firstChar = numString.charAt(0);
        numString = numString.substring(1, numString.length()) + String.valueOf(firstChar);
        int number = Integer.parseInt(numString);
        return number;
    }

    public int commandR(){

        String numString = changeString(this.curNumber);
        char finalChar = numString.charAt(numString.length()-1);
        numString = String.valueOf(finalChar) + numString.substring(0, numString.length()-1);
        int number = Integer.parseInt(numString);
        return number;
    }

    // 현재 숫자 문자열변환
    private String changeString(int number){

        // 숫자의 각 자릿수별로 다르게 문자열 변환
        String str = String.valueOf(number);

        if(str.length() == 4){
            return str;
        }
        else if(str.length() == 3){
            return "0" + str;
        }
        else if(str.length() == 2){
            return "00" + str;
        }
        else{
            return "000" + str;
        }
    }
}