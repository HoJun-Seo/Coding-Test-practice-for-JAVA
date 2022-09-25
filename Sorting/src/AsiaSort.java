import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;

public class AsiaSort {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int student = Integer.parseInt(br.readLine());
        String[] studentArray = new String[student];
        Integer[] scoreArray = new Integer[student];

        for(int i = 0; i < studentArray.length; i++){
            studentArray[i] = br.readLine();
            String[] data = studentArray[i].split(" ");
            scoreArray[i] = Integer.parseInt(data[2]);
        }

        Arrays.sort(scoreArray, Comparator.reverseOrder());

        HashMap<String, LinkedList<String>> rank = new HashMap<>();

        int count = 0;
        for(int i = 0; i < scoreArray.length; i++){

            if(count == 3) break;
            else{

                int index = i;
                String studentData = (String) Arrays.stream(studentArray).filter(x -> x.contains(String.valueOf(scoreArray[index]))).toArray()[0];
                String[] data = studentData.split(" ");
    
                LinkedList<String> studentList = new LinkedList<>();
                if(rank.containsKey(data[0])){
                    studentList = rank.get(data[0]);
                    if(studentList.size() < 2){
                        studentList.add(data[1]);
                        rank.put(data[0], studentList);
                        count++;
                        bw.write(data[0] + " " + data[1] + "\n");
                    }
                }
                else{
                    studentList.add(data[1]);
                    rank.put(data[0], studentList);
                    count++;
                    bw.write(data[0] + " " + data[1] + "\n");
                }
            }  
        }
        bw.flush();
        bw.close();
        br.close();

    }
}
