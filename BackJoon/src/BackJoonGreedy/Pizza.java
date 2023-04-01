package BackJoonGreedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Pizza {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new Pizza().solution();
    }

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int count = Integer.parseInt(br.readLine());
        Integer [] pizza = new Integer[count];
        int result = 100;
        int pizzaCount = 1;
        for(int i = 0; i < count; i++){
            String str = br.readLine();

            if(str.equals("1/4")){
                pizza[i] = 25;
            }
            else if(str.equals("1/2")){
                pizza[i] = 50;
            }
            else if(str.equals("3/4")){
                pizza[i] = 75;
            }
        }

        Arrays.sort(pizza, Collections.reverseOrder());
        List<Integer> spare = new ArrayList<>();
        for(int i = 0; i < count; i++){
            if(result >= pizza[i]){
                result -= pizza[i];
            }
            else{
                spare.add(result);
                
                // 남았던 것들 중에 크기를 만족할 수 있는 피자 조각이 남아있는 경우
                int index = i;
                if(spare.stream().filter(x -> x >= pizza[index]).count() > 0){
                    for(int j = 0; j < spare.size(); j++){
                        if(spare.get(j) >= pizza[index]){
                            spare.remove(j);
                            break;
                        }
                    }
                }
                else{
                    pizzaCount++;
                    result = 100 - pizza[i];
                }
            }
        }

        bw.write(pizzaCount + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}