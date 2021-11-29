package Heap;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;

public class Heap_main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		bw.write("데이터를 입력하세요 : ");
		bw.flush();
		int number = Integer.parseInt(br.readLine());
		Heap heap = new Heap(number);
		
		bw.write("데이터가 정상적으로 입력 되었습니다.\n");
		bw.write("힙 트리가 생성 되었습니다.\n\n");
		
		while(true) {
			bw.write("메뉴를 선택하세요\n");
			bw.write("1. 데이터 추가\n");
			bw.write("2. 데이터 삭제\n");
			bw.write("3. 힙 트리 전체 출력\n");
			bw.write("4. 프로그램 종료\n");
			bw.write("번호를 입력하세요(숫자) : ");
			bw.flush();
			
			int option = Integer.parseInt(br.readLine());
			
			if(option == 4) {
				bw.write("프로그램이 종료됩니다.\n");
				bw.flush();
				break;
			}
			else if(option == 1) {
				bw.write("\n데이터를 입력하세요 : ");
				bw.flush();
				int data = Integer.parseInt(br.readLine());
				if(heap.insert(data)) {
					bw.write("데이터가 정상적으로 삽입 되었습니다.\n\n");
					bw.flush();
				}
			}
			else if(option == 2) {
				int pop = heap.pop();
				
				bw.write("\n데이터가 정상적으로 삭제 되었습니다.\n");
				bw.write("삭제된 데이터 : " + pop + "\n\n");
				bw.flush();
				
			}
			else if(option == 3) {
				List<Integer> heapTree = heap.getHeapArray();
				if(heapTree != null) {
					bw.write("\n힙 트리 전체를 출력합니다.\n");
					heapTree.stream().forEach(x -> {
						try {
							bw.write(x + " ");
							bw.flush();
						} catch (IOException e) {
							e.printStackTrace();
						}
					});
					
					bw.write("\n\n");
					bw.flush();
				}
				else {
					bw.write("\n힙 트리가 존재하지 않습니다.\n");
					bw.write("힙 트리를 만들어주세요\n\n");
					bw.flush();
				}
			}
			
		}	
	}
}
