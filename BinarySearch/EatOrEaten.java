import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class EatOrEaten {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        int[] resultArray = new int[count];
        
        for(int i = 0; i < count; i++){

            String[] arraySize = br.readLine().split(" ");
            int sizeA = Integer.parseInt(arraySize[0]);
            int sizeB = Integer.parseInt(arraySize[1]);

            int[] arrayA = new int[sizeA];
            int[] arrayB = new int[sizeB];

            String[] inputA = br.readLine().split(" ");
            String[] inputB = br.readLine().split(" ");

            for(int j = 0; j < arrayA.length; j++){
                arrayA[j] = Integer.parseInt(inputA[j]);
            }
            for(int j = 0; j < arrayB.length; j++){
                arrayB[j] = Integer.parseInt(inputB[j]);
            }

            Arrays.sort(arrayB); // B 배열 정렬

            // 이분 탐색으로 B 배열에서 A 배열의 각 요소 기준 해당 값보다 더 작은 숫자중에 가장 큰값의 위치를 찾는다.
            // 위치를 찾으면 해당 위치 값 인덱스 + 1을 결과값에 더해준다.
            int result = 0;
            
            for(int j = 0; j < arrayA.length; j++){
                
                int standard = arrayA[j];
                int start = 0;
                int end = arrayB.length - 1;
                while(start <= end){
                    int mid = (start + end) / 2;

                    if(arrayB[mid] >= standard){
                        end = mid-1;
                    }
                    else if(arrayB[mid] < standard){ 
                        // 먹을 수 있는것을 발견한 경우 인덱스를 1씩 더하며 기준값보다 인덱스 값이 더 커지는 경우를 찾는다.
                        // 발견할 수 없는 경우 해당 기준값에서는 B 의 먹이를 전부 다 먹을 수 있는것으로 간주한다.
                        while(mid < arrayB.length){
                            if(arrayB[mid] < standard){
                                bw.write("중간값 : " + mid + "\n");
                                mid++;
                            }
                        }
                        result += mid;
                        break;
                    }
                }
            }

            resultArray[i] = result;
        }

        for(int i = 0; i < count; i++){
            bw.write(resultArray[i] + "\n");
        }
        bw.flush();
        bw.close();
    }
}
