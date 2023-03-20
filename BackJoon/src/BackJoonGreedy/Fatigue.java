package BackJoonGreedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Fatigue {
    public static void main(String[] args) throws IOException {
        new Fatigue().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int fatigueQuantity = Integer.parseInt(input[0]);
        int workQuantity = Integer.parseInt(input[1]);
        int restQuantity = Integer.parseInt(input[2]);
        int maxWorkQuantity = Integer.parseInt(input[3]);

        int currentFatigue = 0;
        int currentWork = 0;
        for(int i = 0; i < 24; i++){

            if(currentFatigue + fatigueQuantity <= maxWorkQuantity){
                currentWork += workQuantity;
                currentFatigue += fatigueQuantity;
            }
            else{
                currentFatigue -= restQuantity;
                if(currentFatigue < 0) 
                    currentFatigue = 0;
            }
        }

        bw.write(currentWork + "\n");
        bw.flush();
        bw.close();
        br.close();
        
    }
}