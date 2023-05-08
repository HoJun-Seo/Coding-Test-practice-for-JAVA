package BackJoonBinarySearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class ArrayFullSearch {
    public static void main(String[] args) throws IOException {
        new ArrayFullSearch().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        long[] a = new long[n];
        input = br.readLine().split(" ");

        for(int i = 0; i < a.length; i++){
            a[i] = Long.parseLong(input[i]);
        }

        Arrays.sort(a);

        for(int i = 0; i < m; i++){
            input = br.readLine().split(" ");
            int category = Integer.parseInt(input[0]);

            int start = 0;
            int end = n - 1;
            // 입력 받은 숫자보다 크거나 같은 숫자의 갯수
            if(category == 1){
                long k = Long.parseLong(input[1]);
                
                if(a[n - 1] < k){
                    bw.write(0 + "\n");
                }
                else if(a[0] >= k){
                    bw.write(n + "\n");
                } else{
                    while(start <= end){
                        int mid = (start + end) / 2;
    
                        // 입력 받은 값보다 작은경우
                        if(a[mid] < k){
                            start = mid + 1;
                        }
                        else {
                            // 입력 받은 값 보다 크거나 같은 경우
                            // 중복이 허용되는 배열에 대한 처리
                            end = mid - 1;
                        }
                    }
    
                    bw.write(((n-1) - end) + "\n");
                }
            }
            // 입력 받은 숫자보다 큰 숫자의 갯수
            else if(category == 2){
                long k = Long.parseLong(input[1]);

                if(a[n - 1] <= k){
                    bw.write(0 + "\n");
                } else if(a[0] > k){
                    bw.write(n + "\n");
                } else {
                    while(start <= end){
                        int mid = (start + end) / 2;
    
                        // 입력받은 값보다 작거나 같은 경우
                        if(a[mid] <= k){
                            start = mid + 1;
                        }
                        else{
                            // 입력받은 값 보다 큰 경우
                            // 중복이 허용되는 배열에 대한 처리
                            end = mid - 1;
                        }
                    }
    
                    bw.write(((n-1) - end) + "\n");
                }
            }
            // i 보다 크거나 같고, j 보다 작거나 같은 숫자의 갯수 
            else if(category == 3){
                long number1 = Long.parseLong(input[1]);
                long number2 = Long.parseLong(input[2]);

                // 두 가지 조건의 범위를 따로따로 구한 다음에
                // 중첩되는 만큼만 뽑아낸다
                int low = 0;
                int high = 0;
                while(start <= end){
                    int mid = (start + end) / 2;

                    // i 보다 작은 경우
                    if(a[mid] < number1){
                        start = mid + 1;
                    } else{
                        // i 보다 크거나 같은 경우
                        end = mid - 1;
                    }
                }

                low = end;

                start = 0;
                end = n - 1;
                while(start <= end){
                    int mid = (start + end) / 2;

                    // j 보다 큰 경우
                    if(a[mid] > number2){
                        end = mid - 1;
                    } else{
                        // j 보다 작거나 같은 경우
                        start = mid + 1;
                    }
                }

                high = start;

                bw.write((high - low - 1) + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}