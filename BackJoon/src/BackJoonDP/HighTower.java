package BackJoonDP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class HighTower {
	/*
	 * 가장 긴 증가하는 부분 수열(LIS) 문제의 심화 변형 문제이다.
	 * 벽돌의 수가 N개 일때, 시간 복잡도 O(N^2) 으로 해결할 수 있다.
	 * 벽돌의 번호를 출력해야 한다는 점에서, 계산된 테이블을 역추적할 수 있어야 한다.
	 * 
	 * 가장 먼저 벽돌을 무게 기준으로 정렬한다.
	 * D[i] = 인덱스가 i 인 벽돌을 가장 아래에 두었을 때의 최대 높이
	 * 각 벽돌에 대해서 확인하며 D[i] 를 갱신한다.
	 * 모든 0 <= j < i 에 대하여, D[i] = max(D[i], D[j]+height[i]) if area[i] > area[j]
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int blockCount = Integer.parseInt(br.readLine());
		
		Block[] blockArray = new Block[blockCount+1];
		blockArray[0] = new Block(0, 0, 0, 0);
		StringTokenizer st = null;
		for(int i = 1; i < blockArray.length; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int underside = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			Block block = new Block(i, underside, height, weight);
			blockArray[i] = block;
		}
		
		// 무게 순 정렬
		Arrays.sort(blockArray);
		
		// 각 인덱스가 가장 아래에 있을 경우 만들 수 있는 탑 높이의 최대 값과 쌓여진 결과를 해시맵에 저장한다.
		int[] dp = new int[blockCount+1];
		for(int i = 1; i < blockCount+1; i++) {
			for(int j = 0; j < i; j++) {
				if(blockArray[i].getUnderside() > blockArray[j].getUnderside()) {
					dp[i] = Math.max(dp[i], dp[j]+blockArray[i].getHeight());
				}
			}
		}
		
		int max = Arrays.stream(dp).max().getAsInt();
		int index = blockCount;
		
		List<Integer> resultList = new ArrayList<Integer>();
		
		while(index != 0) {
			if(max == dp[index]) {
				resultList.add(blockArray[index].getBlockNumber());
				max -= blockArray[index].getHeight();
			}
			index--;
		}
		
		Collections.reverse(resultList);
		Object[] resultArray = resultList.toArray();
		bw.write(resultArray.length + "\n");
		for(int i = 0; i < resultArray.length; i++) {
			bw.write((int)resultArray[i] + "\n");
		}
		bw.flush();
		bw.close();
	}
}

class Block implements Comparable<Block>{
	private int blockNumber;
	private int underside;
	private int height;
	private int weight;
	
	public Block(int blockNumber, int underside, int height, int weight) {
		this.blockNumber = blockNumber;
		this.underside = underside;
		this.height = height;
		this.weight = weight;
	}
	
	public int getBlockNumber() {
		return blockNumber;
	}
	public int getUnderside() {
		return underside;
	}
	public int getHeight() {
		return height;
	}
	public int getWeight() {
		return weight;
	}

	@Override
	public int compareTo(Block o) {
		return this.weight - o.getWeight();
	}
}