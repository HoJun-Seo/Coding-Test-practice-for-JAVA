package BackJoonGreedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BookBox {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputArray = br.readLine().split(" ");

        int bookCount = Integer.parseInt(inputArray[0]);
        int boxWeight = Integer.parseInt(inputArray[1]);

        int currentWeight = 0;
        int boxCount = 0;

        if(bookCount == 0){
            bw.write("0");
        }
        else{
            String[] bookArray = br.readLine().split(" ");

            for(int i = 0; i < bookArray.length; i++){
                currentWeight += Integer.parseInt(bookArray[i]);

                if(currentWeight < boxWeight)
                    continue;
                else{
                    if(currentWeight == boxWeight){
                        currentWeight = 0;
                        boxCount++;
                    }
                    else if(currentWeight > boxWeight){
                        currentWeight = Integer.parseInt(bookArray[i]);
                        boxCount++;
                    }
                }
            }

            if(currentWeight > 0)
                boxCount++;

            bw.write(String.valueOf(boxCount));
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
