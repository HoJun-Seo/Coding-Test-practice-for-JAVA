package BackJoonQueue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Concert {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int count = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> firstTicket = new PriorityQueue<Integer>();
		String[] str_firstTicket = br.readLine().split(" ");
		for(int i = 0; i < count; i++) {
			firstTicket.offer(Integer.parseInt(str_firstTicket[i]));
		}
		
		// 1차 티켓팅 결과 1번 표만 팔렸을 경우도 고려해야 한다.
		int secondTicket = 1;
		while(true) {
			int queueHead = 0;
			if(firstTicket.size() == 0) {
				bw.write(secondTicket + "\n");
				bw.flush();
				bw.close();
				break;
			}
			else if(firstTicket.size() != 0) {
				queueHead = firstTicket.poll();
				
				if(secondTicket == queueHead) {
					secondTicket++;
				}else if(secondTicket < queueHead){
					bw.write(secondTicket + "\n");
					bw.flush();
					bw.close();
					break;
				}
			}		
		}	
	}
}
