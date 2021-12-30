package BackJoonGraph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Hacking {
	
	static int V, E, start;
	static int INF = 1000000000;
	static List<List<Computer>> graph;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		List<int[]> resultList = new ArrayList<int[]>();
		
		int count = Integer.parseInt(br.readLine());
		// 첫째줄에 컴퓨터 갯수 n, 의존성 갯수 d, 해킹당한 컴퓨터의 번호 c(1 <= n <= 10000, 1 <= d <= 100000, 1 <= c <= n)
		// 이어서 d 개의 줄에 각 의존성을 나타낸는 정수 a, b, s 가 주어진다.(a != b, 1 <= a, b <= n, 0 <= s <= 1000)
		// 이는 컴퓨터 a 가 컴퓨터 b 를 의존하며, 컴퓨터 b가 감염괴면 s 초 후에 컴퓨터 a 도 감염됨을 뜻한다.
		// 각 테스트 케이스에서 같은 의존성 (a,b) 가 두 번 이상 존재하지 않는다.
		
		// 각 테스트 케이스 마다 한 줄에 걸쳐 총 감염되는 컴퓨터 수, 마지막 컴퓨터가 감염되기까지 걸리는 시간을 공백으로 구분지어 출력한다.
		StringTokenizer st = null;
		int[] time = null;
		for(int i = 0; i < count; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			
			graph = new ArrayList<List<Computer>>();
			
			for(int x = 0; x < V+1; x++) {
				graph.add(new ArrayList<Computer>()); // 각 노드에 대한 연결 노드 정보를 저장할 리스트 저장
			}
			
			// 그레프 연결 정보 입력
			for(int x = 0; x < E; x++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				
				// b가 a에게 의존한다 : b -> a 방향 간선 연결
				graph.get(b).add(new Computer(a, s));
			}
			
			time = new int[V+1]; // 최소 시간 정보를 저장할 배열
			for(int x = 0; x < time.length; x++) {
				if(x == start) { // 시작 지점의 경우 0으로 초기화
					time[x] = 0;
				}
				else
					time[x] = INF;
			}
			
			PriorityQueue<Computer> prior = new PriorityQueue<Computer>((o1,o2) -> Integer.compare(o1.getTime(), o2.getTime()));
			prior.offer(new Computer(start, 0));
			
			while(!prior.isEmpty()) {
				Computer computer = prior.poll();
				
				if(time[computer.getIdx()] < computer.getTime()) {
					continue;
					// 이미 방문을 통해 시간 최소값이 갱신된 노드의 경우 스킵
				}
				else {
					for(int x = 0; x < graph.get(computer.getIdx()).size(); x++) {
						Computer connectCom = graph.get(computer.getIdx()).get(x);
						
						if(time[connectCom.getIdx()] > computer.getTime() + connectCom.getTime()) {
							time[connectCom.getIdx()] = computer.getTime() + connectCom.getTime();
							prior.offer(new Computer(connectCom.getIdx(), time[connectCom.getIdx()]));
						}
					}
				}
			}
			
			// time 배열을 결과 리스트에 저장
			resultList.add(time);
		}
		
		// 결과 출력
		for(int i = 0; i < resultList.size(); i++) {
			int[] result = resultList.get(i);
			
			long hackComputer = Arrays.stream(result).filter(x -> x != INF).count();
			int maxTime = Arrays.stream(result).filter(x -> x != INF).max().getAsInt();
			
			bw.write(hackComputer + " " + maxTime + "\n");
		}
		bw.flush();
		bw.close();
	}
}

class Computer{
	private int idx;
	private int time;
	
	public Computer(int idx, int time) {
		this.idx = idx;
		this.time = time;
	}
	
	public int getIdx() {
		return idx;
	}
	public int getTime() {
		return time;
	}
}