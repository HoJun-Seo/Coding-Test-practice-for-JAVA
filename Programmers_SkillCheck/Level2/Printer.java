import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Printer {
    public static void main(String[] args) {
        int[] priorities = {2, 1, 3, 2};
        int location = 2;
        new Printer().solution(priorities, location);
    }

    public int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<Print> queue = new LinkedList<>();
        boolean check = true;

        for(int i = 0; i < priorities.length; i++){
            Print print = new Print(priorities[i], false);
            if(i == location) 
                print.check = true;

            queue.offer(print);
        }
        while(check){
            Print print = queue.peek();
            Print max = Collections.max(queue);

            if(print.value == max.value){
                queue.poll();
                answer++;

                if(print.check)
                    check = false;
            }
            else{
                queue.offer(queue.poll());
            }
        }
        System.out.println(answer);
        return answer;
    }
}

class Print implements Comparable<Print>{
    int value;
    boolean check;

    public Print(int value, boolean check){
        this.value = value;
        this.check = check;
    }

    @Override
    public int compareTo(Print o) {
        return this.value - o.value;
    };
}
