package Class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class WordStudy {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = br.readLine().toUpperCase();
		
		char[] wordcount = word.toCharArray();
		List<String> str_list = new ArrayList<String>();
		
		for(int i = 0; i < wordcount.length; i++) {
			str_list.add(String.valueOf(wordcount[i]));
		}
		int oldcount = 0; // 이전 문자 갯수
		int newcount = 0; // 그 다음 문자 갯수
		boolean overlap = false; // 최대 갯수 중복 여부
		
		String current_most = ""; // 문자열에서 최종적으로 가장 많은 문자 
		
		for(int i = 0; i < str_list.size(); i++) {
			// 첫번째 문자 부터 문자열에 몇개 포함되어 있는지 카운트 한다.
			// 카운트가 끝난 문자는 문자열에서 제거한다.
			// 이전에 카운트 된 숫자와 새로 카운트된 숫자를 비교하여 카운트 숫자가 더 큰 글자를 current_most 에 저장해둔다.
			
			// 현재 인덱스 문자 저장
			String current_str = str_list.get(i); 
			// 현재 인덱스 문자 갯수 카운트
			newcount = (int) str_list.stream().filter(x -> x.equals(current_str)).count();
			
			if (oldcount < newcount) {
				String mostcount = str_list.get(i); // 문자열에서 해당 문자를 삭제하기 위한 변수 적재
				str_list.removeIf(x -> x.equals(mostcount)); // 현재 최대 갯수 문자 삭제
				oldcount = newcount; // 다음 비교를 위해 이전 문자 갯수에 현재 문자 갯수값 저장
				current_most = mostcount; // 현재 최대 갯수 문자 저장
				
				overlap = false;
			} else if(oldcount > newcount) {
				// 현재 문자 갯수가 이전에 카운트 했던 문자 갯수보다 작으므로 곧장 다음으로 넘어감
				String minicount = str_list.get(i);
				str_list.removeIf(x -> x.equals(minicount)); // 최대 갯수가 아닌 문자 또한 삭제
				continue;
			}else {
				String overlapcount = str_list.get(i);
				str_list.removeIf(x -> x.equals(overlapcount)); // 중복인 문자 또한 삭제
				overlap = true; // 이전 문자 갯수와 현재 문자 갯수가 같은 경우 일단 최대 갯수 중복으로 체크
			}
		}
		
		if(overlap)
			System.out.println("?");
		else
			System.out.println(current_most);
	}
}
