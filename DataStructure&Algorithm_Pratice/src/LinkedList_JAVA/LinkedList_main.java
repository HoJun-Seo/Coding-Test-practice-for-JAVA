package LinkedList_JAVA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class LinkedList_main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		bw.write("데이터를 입력하세요 : ");
		bw.flush();
		int data = Integer.parseInt(br.readLine());
		NodeMgmt ngmt = new NodeMgmt(data);
		bw.write("연결 리스트의 헤더가 생성 완료되었습니다.\n");
		bw.flush();
		
		while(true) {
			String option = "";
			bw.write("메뉴를 선택하세요 \n");
			bw.write("1. 연결 리스트 전체 출력\n");
			bw.write("2. 연결 리스트 데이터 추가\n");
			bw.write("3. 연결 리스트 데이터 삭제\n");
			bw.write("4. 프로그램 종료\n");
			bw.write("메뉴 선택 : ");
			bw.flush();
			
			option = br.readLine();
			
			if(option.equals("4")) {
				bw.write("프로그램이 종료됩니다.\n");
				bw.flush();
				break;
			}
			else if(option.equals("1")) {
				bw.write("\n연결 리스트 전체를 출력합니다.\n");
				bw.flush();
				ngmt.desc();
				bw.write("\n");
				bw.flush();
			}
			else if(option.equals("2")) {
				bw.write("\n연결 리스트에 데이터를 추가합니다.\n");
				bw.write("추가를 원하는 데이터를 입력하세요(숫자) : ");
				bw.flush();
				int insert_data = Integer.parseInt(br.readLine());
				ngmt.add(insert_data);
				bw.write("데이터가 정상적으로 추가 되었습니다.\n");
				bw.write("\n");
				bw.flush();
			}
			else if(option.equals("3")) {
				bw.write("\n연결 리스트에 데이터를 삭제합니다.\n");
				bw.write("삭제를 원하는 데이터를 입력하세요(숫자) : ");
				bw.flush();
				int delete_data = Integer.parseInt(br.readLine());
				ngmt.delete(delete_data);
			}
			else {
				bw.write("잘못된 입력입니다. 다시 입력해 주십시오\n");
				bw.flush();
			}
				
		}
			
		bw.close();
	}
}
