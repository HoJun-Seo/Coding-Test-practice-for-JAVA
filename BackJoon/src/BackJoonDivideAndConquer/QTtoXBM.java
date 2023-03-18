package BackJoonDivideAndConquer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class QTtoXBM {

    static String[][] quadTree = null;
    static String s = null;
    static int index = 0;

    public static void main(String[] args) throws NumberFormatException, IOException {
        new QTtoXBM().solution();
    }

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(br.readLine());
        s = br.readLine();

        quadTree = new String[size][size];

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(quadTree[i][j] == null)
                    bwRecursive(i, j, 1);
            }
        }

        bw.write("#define quadtree_width " + size + "\n");
        bw.write("#define quadtree_height " + size + "\n");
        bw.write("static char quadtree_bits[] = {\n");
        
        for(int i = 0; i < size; i++){
            Queue<String> hexCode = new LinkedList<>();
            int number = size / 8;

            String str = String.join("", quadTree[i]);
            int start = 0;
            int end = 8;
            for(int j = 0; j < number; j++){
                hexCode.offer(str.substring(start, end));
                start += 8;
                end += 8;
            }

            while(!hexCode.isEmpty()){
                str = hexCode.poll();
                str = str.replaceAll("W", "0");
                str = str.replaceAll("B", "1");

                // 2진수 계산 원래 방식의 반대로 해줘야 함
                int decimal = 0;
                for(int j = 0; j < str.length(); j++){
                    if(str.charAt(j) == '1'){
                        decimal += (int)Math.pow(2, j);
                    }
                }
                
                String hex = Integer.toHexString(decimal);
                StringBuilder sb = new StringBuilder(hex);

                if(sb.length() == 1){
                    sb.insert(0, "0x0");
                }
                else if(sb.length() == 2){
                    sb.insert(0, "0x");
                }
                bw.write(sb.toString() + ",");
            }
            bw.write("\n");
        }
        bw.write("};\n");
        
        bw.flush();
        bw.close();
        br.close();
    }

    private void bwRecursive(int i, int j, int depth) {
        // Q가 발견되면 for 문을 통해 무조건 뒤에 따라오는 네 자리문자를 모두 다 본다.
        if(s.charAt(index) == 'Q'){
            index++;
            depth *= 2; // Q 가 발견되었으므로 depth 를 높임
            int range = quadTree[0].length / depth;

            // 어쨌든 for 문만 들어가면 Qxxxx 내부에서 Q가 몇번을 더 나오든 확실하게 처리된다.
            for(int x = 0; x < 4; x++){
                // Q 를 감지해서 들어왔을때는 index 가 문자열의 길이값을 넘어갈일이 없을 것이다.
                // 그래도 안전을 위해 달아둔다.
                if(index >= s.length())  
                    break;

                fillArray(i, j, x, range, depth);
                
            }
        }
        // Q 를 만나지 않았을 경우 처리
        else {
            int range = quadTree[0].length / depth;

            for(int x = 0; x < 4; x++){
                if(index >= s.length()) 
                    break;

                fillArray(i, j, x, range, depth);
            }
        }
    }

    private void fillArray(int i, int j, int x, int range, int depth){
        int xIdx = i;
        int yIdx = j;

        if(x == 1){
            yIdx = j + range;
        }
        else if(x == 2){
            xIdx = i + range;
        }
        else if(x == 3){
            xIdx = i + range;
            yIdx = j + range;
        }
            
        if(s.charAt(index) == 'Q'){
            bwRecursive(xIdx, yIdx, depth);
        }
        else{
            if(s.charAt(index) == 'B'){
                for(int xxIdx = xIdx ; xxIdx < xIdx + range; xxIdx++){
                    for(int yyIdx = yIdx ; yyIdx < yIdx + range; yyIdx++){
                        quadTree[xxIdx][yyIdx] = "B";
                    }
                }
            }
            else if(s.charAt(index) == 'W'){
                for(int xxIdx = xIdx ; xxIdx < xIdx + range; xxIdx++){
                    for(int yyIdx = yIdx ; yyIdx < yIdx + range; yyIdx++){
                        quadTree[xxIdx][yyIdx] = "W";
                    }
                }
            }
            // 재귀 호출일때와 아닐때의 index 증가 연산을 분리해놔야 함
            index++;
        }
    }
}