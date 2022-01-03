package BackJoonBackTracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Password {
	// 입력으로 들어오는 글자는 최소 3글자, 최대 15글자이다.
	// 또한 글자는 중복되지 않는다.
	// 모음이 최소 1글자, 자음이 최소 2글자는 있어야 한다.
	// dfs 탐색을 하면서 문자열을 만들되, 규칙에 위배되는 경우 백트래킹(조합 구현)
	// 규칙에 맞게 문자열에 만들어 졌을 경우 결과 리스트에 저장해준다.
	
	static List<String> resultList = new ArrayList<String>();
	static List<Integer> visited = new ArrayList<Integer>();
	static String str = "";
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int passwordLength = Integer.parseInt(st.nextToken());
		int wordCount = Integer.parseInt(st.nextToken());
		
		String[] vowel = {"a", "e", "i", "o", "u"}; // 모음 글자 배열
		
		String[] wordArray = new String[wordCount];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < wordArray.length; i++) {
			wordArray[i] = st.nextToken();
		}
		
		Arrays.sort(wordArray);
		
		combination(wordArray, passwordLength, 0);
		
		for(String password : resultList) {
			
			int count = 0;
			for(int i = 0; i < password.length(); i++) {
				char word = password.charAt(i);
				
				if(Arrays.stream(vowel).anyMatch(x -> x.equals(String.valueOf(word)))) {
					count++;
				}
			}
			
			if(count >= 1 && count <= passwordLength-2) {
				bw.write(password + "\n");
			}
		}
		
		bw.flush();
		bw.close();
	}

	private static void combination(String[] wordArray, int length, int index) {
		
		if(str.length() == length) {
			String result = str;
			resultList.add(result);
		}
		else {
			for(int i = index; i < wordArray.length; i++) {
				if(visited.contains(i))
					continue;
				else {
					str += wordArray[i];
					visited.add(i);
					combination(wordArray, length, i+1);
					str = str.substring(0, str.length()-1);
					visited.remove(visited.size()-1);
				}
			}
		}
		
	}
}
