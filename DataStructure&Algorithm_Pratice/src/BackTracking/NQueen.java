package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class NQueen {
	public static void main(String[] args) {
		int n = 4; // 배치해야 하는 퀸의 갯수
		// 배치 형태를 리스트 형태로 저장
		List<Integer> list = new ArrayList<Integer>();
		List<List<Integer>> finalResult = new ArrayList<List<Integer>>();
		
		dfs(n, 0, list, finalResult);
		
		finalResult.stream().forEach(x -> System.out.println(x.toString()));
	}

	private static void dfs(int n, int currentRow, List<Integer> currentCandidate, List<List<Integer>> finalResult) {
		// currentCandidate : 이전 행에서 퀸 들의 배치 정보
		if(currentRow == n) { // 배치가 모두 끝났을 경우
			List<Integer> resultList = new ArrayList<Integer>();
			for(int i = 0; i < currentCandidate.size(); i++) {
				resultList.add(currentCandidate.get(i));
			}
			finalResult.add(resultList);
		}
		else { // 배치가 다 끝나지 않았을 경우
			// candidateCol : 체크 해야 하는 열의 번호
			for(int candidateCol = 0; candidateCol < n; candidateCol++) {
				// 조건에 만족하는 열이 있는 경우
				if(isAvailable(currentCandidate, candidateCol)) {
					currentCandidate.add(candidateCol);
					dfs(n, currentRow+1, currentCandidate, finalResult);
					
					// 위의 dfs 재귀 문에서 조건에 만족하는 열을 찾지 못하여 그냥 return 을 받았을 경우
					// 가장 최근에 배치된 퀸의 정보를 삭제하고, 삭제한 해당 행의 퀸 부터 다시 배치를 시작한다.(백트래킹)
					// 다음 행에 대한 퀸의 배치가 불가능해 졌으므로, 이전 행의 퀸의 위치를 이전과는 다른 곳으로 다시 배치한다.
					currentCandidate.remove(currentCandidate.size()-1);
				}
			}
		}
	}

	// 수직 체크 및 대각선 체크
	private static boolean isAvailable(List<Integer> currentCandidate, int candidateCol) {
		
		int currentRow = currentCandidate.size();
		
		for(int queenRow = 0; queenRow < currentRow; queenRow++) {
			if(currentCandidate.get(queenRow) == candidateCol ||
					Math.abs(currentCandidate.get(queenRow) - candidateCol)
					== currentRow - queenRow)
				return false;
		}
		return true;
	}
}
