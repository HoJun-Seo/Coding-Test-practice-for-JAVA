package Class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WordSort {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<String> stringSort = new ArrayList<String>();
		List<String> resultList = new ArrayList<String>();
		int stringCount = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < stringCount; i++) {
			stringSort.add(br.readLine());
		}
		
		stringSort = stringSort.stream().distinct().collect(Collectors.toList()); // 중복 제거 후 다시 리스트 반환
		
		int[] stringLength = new int[stringSort.size()];
		for(int i = 0; i < stringLength.length; i++) {
			stringLength[i] = stringSort.get(i).length();
		}
		
		int min = Arrays.stream(stringLength).min().getAsInt(); // 문자열 중 최소 길이값
		int max = Arrays.stream(stringLength).max().getAsInt(); // 문자열 중 최대 길이값
		
		for(int i = min; i <= max; i++) {
			List<String> str_temp = new ArrayList<String>(); // 각 길이별로 문자열을 적재해줄 임시 리스트 선언
			
			for(int index = 0; index < stringSort.size(); index++) {
				if(stringSort.get(index).length() == i) { // 현재 체크 중인 길이와 똑같은 길이의 문자열이 발견될 경우
					str_temp.add(stringSort.get(index));
				}
			}
			
			if(str_temp.size() > 1) {
				// 같은 길이의 문자열이 여러개 있을 경우 사전 순으로 정렬
				str_temp = str_temp.stream().sorted().collect(Collectors.toList());
				for(int x = 0; x < str_temp.size(); x++) {
					resultList.add(str_temp.get(x));
				}
			}else if(str_temp.size() == 1){
				// 같은 길이의 문자열이 여러개 있지 않고 독립적으로 존재하는 경우
				resultList.add(str_temp.get(0));
			} else
				continue;
		}
		
		resultList.stream().forEach(x -> System.out.println(x));	
	}
}