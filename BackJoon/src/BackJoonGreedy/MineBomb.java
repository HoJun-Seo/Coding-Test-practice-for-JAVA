package BackJoonGreedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MineBomb {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());

        Mine[] mineArray = new Mine[count]; // 정렬 및 인덱스 확인
        int[] array = new int[count]; // 요소가 0인 경우 지뢰가 터졌다는 의미
        List<Integer> resultList = new ArrayList<>();

        for(int i = 0; i < mineArray.length; i++){    
            Mine mine = new Mine();
            mine.index = i;
            mine.value = Integer.parseInt(br.readLine());

            array[i] = mine.value;
            mineArray[i] = mine;
        }

        Arrays.sort(mineArray);

        for(int i = 0; i < mineArray.length; i++){
            Mine mine = mineArray[i];

            int index = mine.index;
            int value = mine.value;
            if(array[index] > 0){ // 지뢰가 터지지 않은 곳일 경우
                array[index] = 0;

                resultList.add(index+1);
                boolean leftBomb = true;
                boolean rightBomb = true;
                
                // 왼쪽 확인
                int leftValue = value;
                int leftIndex = index-1;
                while(leftBomb){
                    if(leftIndex >= 0){
                        if(array[leftIndex] < leftValue){
                            leftValue = array[leftIndex];
                            array[leftIndex] = 0;
                            leftIndex--;
                        }
                        else{
                            leftBomb = false;
                        }
                    }
                    else{
                        leftBomb = false;
                    }
                }
                // 오른쪽 확인
                int rightValue = value;
                int rightIndex = index + 1;
                while(rightBomb){
                    if(rightIndex < array.length){
                        if(array[rightIndex] < rightValue){
                            rightValue = array[rightIndex];
                            array[rightIndex] = 0;
                            rightIndex++;
                        }
                        else{
                            rightBomb = false;
                        }
                    }
                    else{
                        rightBomb = false;
                    }
                }
            }
            else{
                continue;
            }
        }

        Object[] resultArray = resultList.toArray();
        Arrays.sort(resultArray);
        for(int i = 0; i < resultArray.length; i++){
            bw.write(resultArray[i] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

class Mine implements Comparable<Mine>{
    int value;
    int index;

    @Override
    public int compareTo(Mine o) {
        
        return o.value - this.value;
    }
}