package BackJoonBruteForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class ArraySpin4 {
	
	static int[][] spinArray;
	static int[][] copyArray;
	static int r;
	static int c;
	static boolean[] visited;
	static List<List<Rotate>> combinateList = new ArrayList<List<Rotate>>();
	static List<Rotate> rotateList = new ArrayList<Rotate>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		List<Rotate> spinList = new ArrayList<Rotate>();
		List<Integer> resultList = new ArrayList<Integer>();
	
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int spinCount = Integer.parseInt(st.nextToken());
		spinArray = new int[x+1][y+1];
		copyArray = new int[x+1][y+1];
		
		for(int i = 1; i < x+1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 1; j < y+1; j++) {
				
				int number = Integer.parseInt(st.nextToken());
				
				spinArray[i][j] = number;
				copyArray[i][j] = number;
			}
		}
		
		for(int i = 0; i < spinCount; i++) {
			
			st = new StringTokenizer(br.readLine(), " ");
			
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			
			Rotate rotate = new Rotate(r, c, s);
			
			spinList.add(rotate);
		}
		
		visited = new boolean[spinList.size()];
		
		// 회전 입력값들의 모든 조합을 구해야 한다.
		combination(spinList, spinCount);
		// 큐를 활용하면 각 변을 회전시키기 용이할듯?
		
		// 각 조합별로 배열을 회전시킨 후 최소값을 알아내고 결과 리스트에 적재한다.
		for(int i = 0; i < combinateList.size(); i++) {
			List<Rotate> list = combinateList.get(i);
			
			for(int index = 0; index < list.size(); index++) {
				Rotate rotate = list.get(index);
				spin(rotate.getR(), rotate.getC(), rotate.getS());
			}
			
			// 회전이 끝나면 긱 행의 숫자를 합한 후 최소값을 찾은 다음 결과 리스트에 적재한다.
			int min = Integer.MAX_VALUE;
			
			for(int x1 = 1; x1 < spinArray.length; x1++) {
				int sum = 0;
				for(int y1 = 1; y1 < spinArray[x1].length; y1++) {
					sum += spinArray[x1][y1];
				}
				if(min > sum)
					min = sum;
			}
			
			resultList.add(min);
			// 그 다음엔 배열을 초기 상태로 다시 초기화한다.
			for(int index = 0; index < copyArray.length; index++) {
				spinArray[index] = copyArray[index].clone();
			}
		}
		
		bw.write(Collections.min(resultList) + "\n");
		bw.flush();
		bw.close();
	}
	
	private static void combination(List<Rotate> spinList, int spinCount) {
		if(rotateList.size() == spinCount) {
			List<Rotate> copyList = new ArrayList<Rotate>();
			copyList.addAll(rotateList);
			combinateList.add(copyList);
		}
		else {
			for(int i = 0; i < spinList.size(); i++) {
				if(visited[i])
					continue;
				else {
					rotateList.add(spinList.get(i));
					visited[i] = true;
					combination(spinList, spinCount);
					rotateList.remove(rotateList.size()-1);
					visited[i] = false;
				}
			}
		}
	}
	private static void spin(int r, int c, int s) {
		
		int x1 = r-s;
		int x2 = r+s;
		
		int y1 = c-s;
		int y2 = c+s;
		
		while(true) {
			if((x1-1 == x2+1) && (y1-1 == y2+1))
				break;
			else {
				// 각 변에 맞게 큐를 4개 만들어 회전시켜준다.
				// 회전이 끝나면 각 변에 큐 값을 그대로 적용시켜준다.
				// (x1,y1), (x2,y2) 값을 변경시켜준 후 다음 루프를 수행한다.
				
				Queue<Integer> top = new LinkedList<Integer>();
				Queue<Integer> bottom = new LinkedList<Integer>();
				Queue<Integer> left = new LinkedList<Integer>();
				Queue<Integer> right = new LinkedList<Integer>();
				
				// 시계방향 회전임을 감안하여 큐에 데이터를 넣어준다.
				// 각 변의 마지막 원소는 회전의 용이함을 위해 넣지 않는다.
				
				// top 큐
				for(int i = y2; i > y1; i--) {
					top.offer(spinArray[x1][i]);
				}
				// bottom 큐
				for(int i = y1; i < y2; i++) {
					bottom.offer(spinArray[x2][i]);
				}
				// left 큐
				for(int i = x1; i < x2; i++) {
					left.offer(spinArray[i][y1]);
				}
				// right 큐
				for(int i = x2; i > x1; i--) {
					right.offer(spinArray[i][y2]);
				}
				
				// 각 큐를 한번 회전 시킬때 각 큐의 첫번째 원소를 자신의 앞에 위치해있는 큐의 마지막 원소로 밀어넣는다.
				// 큐를 통한 회전이 완료된 경우 큐에 들어온 각 원소들의 좌표 그대로 다시 배열값을 초기화 한다.
				
				// 큐를 통한 회전
				right.offer(top.poll());
				bottom.offer(right.poll());
				left.offer(bottom.poll());
				top.offer(left.poll());
				
				// 회전된 큐 값을 배열에 그대로 초기화 한다.
				
				for(int i = y2; i > y1; i--) {
					spinArray[x1][i] = top.poll();
				}
				
				for(int i = y1; i < y2; i++) {
					spinArray[x2][i] = bottom.poll();
				}
				// left 큐
				for(int i = x1; i < x2; i++) {
					spinArray[i][y1] = left.poll();
				}
				// right 큐
				for(int i = x2; i > x1; i--) {
					spinArray[i][y2] = right.poll();
				}
				
				// 회전 좌표를 바꿔준다.
				x1++;
				x2--;
				y1++;
				y2--;
			}
		}
	}
}

class Rotate{
	private int r;
	private int c;
	private int s;
	
	public Rotate(int r, int c, int s) {
		this.r = r;
		this.c = c;
		this.s = s;
	}
	
	public int getC() {
		return c;
	}
	public int getR() {
		return r;
	}
	public int getS() {
		return s;
	}
}
