package Class3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class CaIn {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        int[] resultArray = new int[count];

        for(int i = 0; i < count; i++){
            String[] inputArray = br.readLine().split(" ");
            int m = Integer.parseInt(inputArray[0]);
            int n = Integer.parseInt(inputArray[1]);
            // 나머지 연산을 했을 경우 결과가 0 이 나오는 것을 방지하기 위해 1씩 차감
            int x = Integer.parseInt(inputArray[2])-1;
            int y = Integer.parseInt(inputArray[3])-1;

            // m과 n 의 최소공배수를 구해서 최대 반복 값을 찾는다.
            // <m:n> 이 되었을 때, 즉 종말이 도래하는 해가 되었을 때 반복횟수
            int measure = 0;
            if(m > n){
                measure = gcd(m, n);
            }
            else if(m < n){
                measure = gcd(n, m);
            }
            else{
                measure = m; // 서로 같은 값의 두 숫자의 최대 공약수는 자기 자신이다. 
            }

            // 최소 공배수
            int max = (m*n) / measure;

            boolean check = false;
            for(int j = x; j < max; j += m){
                // y 가 n을 초과하게 되면 다시 1로 돌아간다.
                // 이를 역이용 해서 x 가 m 값을 초과해 다시 1로 돌아올만큼 연산 횟수가 증가했을 때, 이를 n 으로 나눈 나머지가 y일 경우 
                // 해당 결과를 얻기까지 연산을 반복한 횟수가 곧 <x:y> 에 해당하는 연도가 된다.(중국인의 나머지 정리)
                if(j % n == y){
                    resultArray[i] = j+1;
                    check = true;
                    break;
                }
            }

            if(!check){
                resultArray[i] = -1;
            }
            
        }

        for(int i = 0; i < resultArray.length; i++){
            bw.write(resultArray[i] + "\n");
        }
        bw.close();
        br.close();
    }

    private static int gcd(int number1, int number2) {
        if(number2 == 0)
            return number1;
        else
            return gcd(number2, number1 % number2);
    }
}