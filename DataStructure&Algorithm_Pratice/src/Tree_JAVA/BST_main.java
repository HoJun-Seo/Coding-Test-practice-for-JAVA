package Tree_JAVA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class BST_main {
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		bw.write("데이터를 입력하세요 : ");
		bw.flush();
		int data = Integer.parseInt(br.readLine());
		BSTMgmt mgnt = new BSTMgmt(new Node(data));
		bw.write("이진 탐색 트리의 루트 노드가 생성 완료되었습니다.\n");
		bw.flush();
		
		while(true) {
			String option = "";
			bw.write("메뉴를 선택하세요 \n");
			bw.write("1. 트리 데이터 삽입\n");
			bw.write("2. 트리 데이터 검색\n");
			bw.write("3. 프로그램 종료\n");
			bw.write("메뉴 선택 : ");
			bw.flush();
			option = br.readLine();
			
			if(option.equals("3")) {
				bw.write("\n프로그램이 종료 됩니다.\n");
				bw.flush();
				break;
			}
			else if(option.equals("1")) {
				bw.write("\n삽입하고자 하는 데이터를 입력하세요(숫자) : ");
				bw.flush();
				mgnt.insert(Integer.parseInt(br.readLine()));
			}
			else if(option.equals("2")) {
				bw.write("\n검색하고자 하는 데이터를 입력하세요(숫자) : ");
				bw.flush();
				mgnt.search(Integer.parseInt(br.readLine()));
			}
		}
	}
}
