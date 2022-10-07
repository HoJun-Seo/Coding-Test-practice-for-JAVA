package Class3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class AC {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        String[] resultArray = new String[count];

        for(int i = 0; i < count; i++){
            Deque<Integer> deque = new ArrayDeque<>();
            String order = br.readLine();

            int deleteCount = 0;

            for(int j = 0; j < order.length(); j++){
                char orderEle = order.charAt(j);
                if(orderEle == 'D'){
                    deleteCount++;
                }
            }

            int inputLength = Integer.parseInt(br.readLine());
            String dequeString = br.readLine();
            int reverseCount = 0;
            
            if(deleteCount > inputLength){
                resultArray[i] = "error";
            }
            else{

                String[] dequeArray = dequeString.split(",");
                dequeArray[0] = dequeArray[0].replace("[", "");
                dequeArray[dequeArray.length-1] = dequeArray[dequeArray.length-1].replace("]", "");

                for(int j = 0; j < inputLength; j++){
                    deque.addLast(Integer.parseInt(dequeArray[j]));
                }

                for(int j = 0; j < order.length(); j++){
 
                    char queueEle = order.charAt(j);
                    if(queueEle == 'R'){
                        reverseCount++;
                    }
                    else if(queueEle == 'D'){
                        if(reverseCount % 2 == 0){
                            deque.pollFirst();
                        }
                        else{
                            deque.pollLast();
                        }
                    }
                }
                if(deque.size() == 0){
                    resultArray[i] = "[]";
                }
                else if(reverseCount % 2 == 0){
                    
                    resultArray[i] = deque.toString().replaceAll(" ", "");
                }
                else{
                    Deque<Integer> reverseDeque = new ArrayDeque<>();
                    int dequeSize = deque.size();
                    for(int j = 0; j < dequeSize; j++){
                        reverseDeque.addLast(deque.pollLast());
                    }

                    resultArray[i] = reverseDeque.toString().replaceAll(" ", "");
                }
            }
        }

        for(int i = 0 ; i < resultArray.length; i++){
            bw.write(resultArray[i] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
            
    }
}
