package BackJoonGreedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class TreeCut {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new TreeCut().solution();
    }

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        String[] tree = br.readLine().split(" ");
        String[] grow = br.readLine().split(" ");

        Tree[] treeArray = new Tree[count];
        for (int i = 0; i < count; i++) {
            int value = Integer.parseInt(tree[i]);
            int growValue = Integer.parseInt(grow[i]);
            Tree treeObject = new Tree(i, value, growValue);

            treeArray[i] = treeObject;
        }

        // 매 반복마다 가장 긴 나무를 자르는 것이 아니라
        // 가장 적게 자라는 나무부터 가장 많이 자라는 나무 순서대로 자르는게 최댓값
        // 반복 도중에 성장하는 만큼 하나하나 더 해주면 시간초과
        // 애초에 자르는 타이밍 오기 전에 자라는 지점까지 전부 다 더해준 다음에 합산한다.
        long result = 0;
        Arrays.sort(treeArray);

        for (int i = 0; i < count; i++) {
            treeArray[i].value += (treeArray[i].growValue * i);
        }
        for (int i = 0; i < count; i++) {
            result += treeArray[i].value;
            treeArray[i].value = 0;
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();

    }
}

class Tree implements Comparable<Tree> {

    int index;
    int value;
    int growValue;

    public Tree(int index, int value, int growValue) {
        this.index = index;
        this.value = value;
        this.growValue = growValue;
    }

    @Override
    public int compareTo(Tree arg0) {
        return this.growValue - arg0.growValue;
    }
}