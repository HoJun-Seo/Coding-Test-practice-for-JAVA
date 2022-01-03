package BackJoonBackTracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Alphabet {
	// DFS 재귀로 해결해야 하는 문제
	// 움직일수 있는 모든 경우의 수 중에서 가장 길이가 긴 경우를 출력해야 한다.
	static char[][] alphabet;
	static HashMap<Integer, String> hashmap;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		alphabet = new char[x][y];
		
		for(int i = 0; i < x; i++) {
			alphabet[i] = br.readLine().toCharArray();
		}
		
		// DFS 알고리즘을 어떤 방식으로 작성하느냐가 핵심
		// 현재 좌표와 현재까지 밟아온 알파벳 리스트를 입력값으로 넘겨준다.
		// 상,하,좌,우 로 이동가능할 경우 이동하면서 해당 좌표로 재귀호출한다.
		// 만약 더 이상 이동이 불가능할 경우 현재까지 만들어진 알파벳 문자열을 결과 리스트에 저장한다.
		x = 0;
		y = 0;
		hashmap = new HashMap<Integer, String>();
		
		String result = "";
		dfs(x,y, result);
		
		Object[] keyArray = hashmap.keySet().toArray();
		Arrays.sort(keyArray);
		int maxSize = (int)keyArray[keyArray.length-1];
		
		bw.write(maxSize + "\n");
		bw.flush();
		bw.close();
	}
	private static void dfs(int x, int y, String result) {
		
		result += alphabet[x][y];
		
		// 각 방향별로 이동할수 있는 공간이 있는지 먼저 확인한다.
		// 이동할 수 있는 경우 해당 자리의 알파벳이 현재 문자열에 들어있는지 그렇지 않은지 확인한다.
		// 들어있지 않은 경우 해당 위치로 이동한다.
		// 들어 있는 경우 해당 위치로 이동하지 않고 다른 위치로 이동할 수 있는지 파악한다.
		// 모든 방면으로 이동할 수 없는 경우 결과 문자열을 resultList 에 추가하고 재귀를 종료한다.
		
		// 위에 이동할 공간이 있는 경우
		if(x-1 >= 0) {
			// 위에 있는 글자가 아직 문자열에 속해 있지 않는 경우
			if(!result.contains(String.valueOf(alphabet[x-1][y]))) {
				dfs(x-1,y,result);
			}
		}
		
		// 아래에 이동할 공간이 있는 경우
		if(x+1 < alphabet.length) {
			if(!result.contains(String.valueOf(alphabet[x+1][y]))) {
				dfs(x+1,y,result);
			}
		}
		
		// 왼쪽에 이동할 공간이 있는 경우
		if(y-1 >= 0) {
			if(!result.contains(String.valueOf(alphabet[x][y-1]))) {
				dfs(x,y-1, result);
			}
		}
		
		// 오른쪽에 이동할 공간이 있는 경우
		if(y+1 < alphabet[0].length) {
			if(!result.contains(String.valueOf(alphabet[x][y+1]))) {
				dfs(x, y+1, result);
			}
		}
		
		// 어디로도 이동할 수 없는 경우
		int size = result.length();
		if(!hashmap.containsKey(size))
			hashmap.put(size, result);
		
	}
}
