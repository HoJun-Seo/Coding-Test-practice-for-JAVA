package BackJoonGreedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ship {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		List<Integer> boxWeight = new ArrayList<Integer>();
		
		int craneCount = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		Integer[] weightLimit = new Integer[craneCount];
		for(int i = 0; i < craneCount; i++) {
			weightLimit[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(weightLimit, Collections.reverseOrder());
		
		int boxCount = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < boxCount; i++) {
			boxWeight.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(boxWeight, Collections.reverseOrder());
		
		int time = 0;
		
		boolean possible = true;
		List<Integer> list = Arrays.asList(weightLimit);
		while(!boxWeight.isEmpty()) {
			Queue<Integer> craneQueue = new LinkedList<Integer>();
			craneQueue.addAll(list);
			// 한번에 최대한 많은 크레인이 일할 수 있게끔 코드를 작성해야 한다.
			
			while(!craneQueue.isEmpty()) {
				
				boolean move = false;
				
				if(boxWeight.isEmpty()) {
					break;
				}
				int crane = craneQueue.peek();
				for(int i = 0; i < boxWeight.size(); i++) {
					int box = boxWeight.get(i);
					if(box > crane) {
						// 시작부터 불가능하면 애초에 상자를 모두 배로 옮기는게 불가능하다.
						if(craneQueue.size() == craneCount) {
							possible = false;
							break;
						}
							
					}
					else if(box <= crane) {
						boxWeight.remove(i);
						craneQueue.poll();
						move = true;
						break;
					}
				}
				
				if(!move)
					break;
			}
			
			if(possible)
				time++;
			else
				break;
		}
		
		if(possible)
			bw.write(time + "\n");
		else
			bw.write(-1 + "\n");
		
		bw.flush();
		bw.close();
	}
}
