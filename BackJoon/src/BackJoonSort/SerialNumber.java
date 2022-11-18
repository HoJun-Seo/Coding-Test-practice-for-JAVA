package BackJoonSort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SerialNumber {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<String> list = new LinkedList<>();

        int count = Integer.parseInt(br.readLine());

        for(int i = 0; i < count; i++){
            list.add(br.readLine());
        }

        String[] resultArray = splitAndMerge(list).toArray(new String[count]);

        for(int i = 0; i < resultArray.length; i++){
            bw.write(resultArray[i] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static List<String> splitAndMerge(List<String> list) {
        if(list.size() <= 1){
            return list;
        }
        
        int half = list.size() / 2;

        List<String> leftList = splitAndMerge(list.subList(0, half));
        List<String> rightList = splitAndMerge(list.subList(half, list.size()));
        return listMerge(leftList, rightList);
    }

    private static List<String> listMerge(List<String> leftList, List<String> rightList) {
        List<String> mergeList = new ArrayList<>();

        int leftIndex = 0;
        int rightIndex = 0;

        while(leftList.size() > leftIndex && rightList.size() > rightIndex){

            String leftElement = leftList.get(leftIndex);
            String rightElement = rightList.get(rightIndex);

            if(leftElement.length() != rightElement.length()){
                if(leftElement.length() > rightElement.length()){
                    mergeList.add(rightElement);
                    rightIndex++;
                }
                else if(leftElement.length() < rightElement.length()){
                    mergeList.add(leftElement);
                    leftIndex++;
                }
            }
            else if(leftElement.length() == rightElement.length()){

                // 길이가 같을 경우 포함하고 있는 숫자 합으로 비교
                int leftSum = 0;
                int rightSum = 0;
                // 숫자가 있는 경우 각 자리 숫자 합 계산
                if(leftElement.matches(".*[0-9].*")){
                    char[] chArray = leftElement.toCharArray();
                    Arrays.sort(chArray);

                    for(int index = 0; index < chArray.length; index++){
                        if((int)chArray[index] >= 48 && (int)chArray[index] <= 57){
                            leftSum += Character.getNumericValue(chArray[index]);
                        }
                        else break;

                    }
                }
                if(rightElement.matches(".*[0-9].*")){
                    char[] chArray = rightElement.toCharArray();
                    Arrays.sort(chArray);

                    for(int index = 0; index < chArray.length; index++){
                        if((int)chArray[index] >= 48 && (int)chArray[index] <= 57){
                            rightSum += Character.getNumericValue(chArray[index]);
                        }
                        else break;
                    }
                }
                // 숫자 합산 후 비교
                if(leftSum < rightSum){
                    mergeList.add(leftElement);
                    leftIndex++;
                }
                else if(leftSum > rightSum){
                    mergeList.add(rightElement);
                    rightIndex++;
                }
                else if(leftSum == rightSum){
                    // 각 자리수 마다 아스키 코드 값으로 비교
                    int index = 0;
                    char[] leftCh = leftElement.toCharArray();
                    char[] rightCh = rightElement.toCharArray();

                    while(index < leftElement.length()){
                        if((int)leftCh[index] > (int)rightCh[index]){
                            mergeList.add(rightElement);
                            rightIndex++;
                            break;
                        }
                        else if((int)leftCh[index] < (int)rightCh[index]){
                            mergeList.add(leftElement);
                            leftIndex++;
                            break;
                        }
                        else {
                            index++;
                        }
                    }
                }
            }
        }

        // 둘 중 남은 요소가 있는 리스트 모두 삽입
        while(leftList.size() > leftIndex){
            // 왼쪽 리스트의 요소가 모두 삽입 되지 않았을 경우
            mergeList.add(leftList.get(leftIndex));
            leftIndex++;
        }

        while(rightList.size() > rightIndex){
            mergeList.add(rightList.get(rightIndex));
            rightIndex++;
        }

        return mergeList;
    }
}