package BackJoonGreedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;

public class Jersey {

    static HashMap<Integer, HashMap<Integer, Integer>> jerseyMap = new HashMap<>();
    static int result = 0;
    public static void main(String[] args) throws NumberFormatException, IOException {
        new Jersey().solution();
    }

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int jerseyCount = Integer.parseInt(br.readLine());
        int studentCount = Integer.parseInt(br.readLine());
        Student[] students = new Student[studentCount];

        for(int i = 0; i < jerseyCount; i++){
            String size = br.readLine();

            HashMap<Integer, Integer> jerseyNumber = null;
            if(size.equals("S")){
                if(jerseyMap.containsKey(0)){
                    jerseyNumber = jerseyMap.get(0);
                    jerseyNumber.put(i+1, 0);
                    jerseyMap.put(0, jerseyNumber);
                }
                else{
                    jerseyNumber = new HashMap<>();
                    jerseyNumber.put(i+1, 0);
                    jerseyMap.put(0, jerseyNumber);
                }
            }
            else if(size.equals("M")){
                if(jerseyMap.containsKey(1)){
                    jerseyNumber = jerseyMap.get(1);
                    jerseyNumber.put(i+1, 0);
                    jerseyMap.put(1, jerseyNumber);
                }
                else{
                    jerseyNumber = new HashMap<>();
                    jerseyNumber.put(i+1, 0);
                    jerseyMap.put(1, jerseyNumber);
                }
            }
            else if(size.equals("L")){
                if(jerseyMap.containsKey(2)){
                    jerseyNumber = jerseyMap.get(2);
                    jerseyNumber.put(i+1, 0);
                    jerseyMap.put(2, jerseyNumber);
                }
                else{
                    jerseyNumber = new HashMap<>();
                    jerseyNumber.put(i+1, 0);
                    jerseyMap.put(2, jerseyNumber);
                }
            }
        }

        for(int i = 0; i < studentCount; i++){
            String[] input = br.readLine().split(" ");

            String size = input[0];
            int number = Integer.parseInt(input[1]);

            Student student = null;
            if(size.equals("S")){
                student = new Student(0, number);
            }
            else if(size.equals("M")){
                student = new Student(1, number);
            }
            else if(size.equals("L")){
                student = new Student(2, number);
            }

            students[i] = student;
        }

        Arrays.sort(students);
        
        for(int i = 0; i < students.length; i++){
            Student student = students[i];
            
            jerseySearch(student);
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }

    private void jerseySearch(Student student) {

        HashMap<Integer, Integer> jerseyNumber = null;
        for(int j = student.size; j <= 2; j++){
            if(jerseyMap.containsKey(j)){
                jerseyNumber = jerseyMap.get(j);
                if(jerseyNumber.containsKey(student.number)){
                    jerseyNumber.remove(student.number);
                    result++;
                    jerseyMap.put(j, jerseyNumber);
                    break;
                }
            }
        }
    }
}

class Student implements Comparable<Student>{
    int size;
    int number;

    public Student(int size, int number){
        this.size = size;
        this.number = number;
    }

    @Override
    public int compareTo(Student o) {
        return this.size - o.size ;
    }
}