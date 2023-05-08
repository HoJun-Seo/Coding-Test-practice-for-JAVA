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
                } else{
                    while(start + 1 < end){
                        int mid = (start + end) / 2;
    
                        if(a[mid] < k){
                            start = mid;
                        }
                        else if(a[mid] > k){
                            end = mid;
                        }
                        else if(a[mid] == k){
                            end = mid;
                            break;
                        }
                    }
    
                    bw.write((n - end) + "\n");
                }
            }
            // 입력 받은 숫자보다 큰 숫자의 갯수
            else if(category == 2){
                long k = Long.parseLong(input[1]);

                if(a[n - 1] <= k){
                    bw.write(0 + "\n");
                } else {
                    while(start + 1 < end){
                        int mid = (start + end) / 2;
    
                        if(a[mid] < k){
                            start = mid;
                        }
                        else if(a[mid] > k){
                            end = mid;
                        }
                    }
    
                    bw.write((n - end) + "\n");
                }
            }
            // i 보다 크거나 같고, j 보다 작거나 같은 숫자의 갯수 
            else if(category == 3){
                long number1 = Long.parseLong(input[1]);
                long number2 = Long.parseLong(input[2]);

                while(start + 1 < end){
                    int mid = (start + end) / 2;

                    
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
