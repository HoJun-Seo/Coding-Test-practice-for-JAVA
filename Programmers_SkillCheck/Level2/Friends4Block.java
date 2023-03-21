import java.util.LinkedList;
import java.util.Queue;

public class Friends4Block {
    public static void main(String[] args) {
        String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
        new Friends4Block().solution(4, 5, board);
    }

    public int solution(int m, int n, String[] board) {
        int answer = 0;

        String[][] friends = new String[m][n];

        for(int i = 0; i < m; i++){
            char[] array = board[i].toCharArray();

            for(int j = 0; j < n; j++){
                friends[i][j] = String.valueOf(array[j]);
            }
        }

        boolean check = true;
        while(check){

            Queue<Erase> queue = new LinkedList<>();
            for(int i = 0; i < m-1; i++){
                for(int j = 0; j < n-1; j++){
                    if(friends[i][j].equals(friends[i][j+1]) && friends[i][j].equals(friends[i+1][j+1]) && friends[i][j].equals(friends[i+1][j]) && !friends[i][j].equals("0")){
                        queue.offer(new Erase(i, j));
                        queue.offer(new Erase(i, j+1));
                        queue.offer(new Erase(i+1, j+1));
                        queue.offer(new Erase(i+1, j));
                    }
                }
            }

            if(queue.size() == 0){
                check = false;
                continue;
            }
    
            while(!queue.isEmpty()){
                Erase erase = queue.poll();
                friends[erase.x][erase.y] = "0";
            }
    
            for(int i = 0; i < n; i++){
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < m; j++){
                    if(!friends[j][i].equals("0"))
                        sb.append(friends[j][i]);
                }
    
                if(sb.length() < m){
                    int size = sb.length();
                    for(int j = 0; j < m - size; j++){
                        sb.insert(0, "0");
                    }
                }

                String str = sb.toString();
                for(int j = 0; j < m; j++){
                    friends[j][i] = String.valueOf(str.charAt(j));
                }
            }
        }
        

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(friends[i][j].equals("0")) 
                    answer++;
            }
        }
        return answer;
    }
}

class Erase {
    int x;
    int y;
    public Erase(int x, int y){
        this.x = x;
        this.y = y;
    }
}
