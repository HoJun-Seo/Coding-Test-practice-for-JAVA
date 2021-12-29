package Class3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class HideAndSeek {
	
	static int start;
	static int end;
	static int count = 0;
	static boolean[] visitCheck;
	static int[] treeRank;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		visitCheck = new boolean[100001];
		treeRank = new int[100001];
		
		// BFS 를 통해 start 부터 end 까지 가는 최단 거리를 구한다.
		// 재귀로 트리를 먼저 만들어 보니 주어진 숫자의 범위상(0 ~ 100000) 뻗어나가서 만들어지는 트리의 노드가 4600개가 넘어가버리면 스택 오버 플로우가 발생해버린다.
		// 그렇기 때문에 패스트 캠퍼스 해설강의에 따라 트리를 따로 만들지 않고 BFS 상에서 조건에 따라 자식노드를 만들어 해당 내용을 큐에 담아주는 방식으로 코드를 작성하자.
		// 트리의 아랫단으로 내려갈 때마다 1초씩 탐색시간을 증가시킨다.
		// 최초로 end에 도달 했을때 걸린 시간을 출력한다.
		bfs(start);
		System.out.println(treeRank[end]);
		
	}

	private static void bfs(int start) {
		Queue<Integer> needVisit = new LinkedList<Integer>();
		Queue<Integer> visited = new LinkedList<Integer>();
		
		needVisit.offer(start);
		
		while(!needVisit.isEmpty()) {
			int node = needVisit.poll();
			
			visited.offer(node);
			visitCheck[node] = true;
			if(node == end)
				break;
			
			int[] childArray = {node-1, node+1, node*2};
			for(int i = 0; i < childArray.length; i++) {
				if((childArray[i] >= 0 && childArray[i] < 100001) && !visitCheck[childArray[i]]) {
					treeRank[childArray[i]] = treeRank[node]+1;
					needVisit.offer(childArray[i]);
					visitCheck[childArray[i]] = true;
				}
			}
		}
	}
}
