package BackJoonSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class TreeTraversal {
	
	
	static HashMap<String, String[]> tree = new HashMap<String, String[]>();
	static List<String> preorderResult = new ArrayList<String>();
	static List<String> inorderResult = new ArrayList<String>();
	static List<String> postorderResult = new ArrayList<String>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int nodeCount = Integer.parseInt(br.readLine());
		
		StringTokenizer st = null;
		for(int i = 0; i < nodeCount; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String mainNode = st.nextToken();
			String leftNode = st.nextToken();
			String rightNode = st.nextToken();
			
			String[] childNode = new String[2];
			if(!leftNode.equals("."))
				childNode[0] = leftNode;
			if(!rightNode.equals("."))
				childNode[1] = rightNode;
			
			tree.put(mainNode, childNode);
			
		}
		
		Object[] keyArray = tree.keySet().toArray();
		Arrays.sort(keyArray);
		
		// 전위 순회
		// 매 재귀 때마다 루트 노드는 출력 리스트에 적재하고, 왼쪽, 오른쪽 자식에 대해 순서대로 재귀 호출
		preorder((String)keyArray[0]);
		// 중위 순회
		// 왼쪽 끝 노드를 찾은 다음 부모, 오른쪽 노드에 대해 순서대로 재귀 호출
		inorder((String)keyArray[0]);
		
		// 후위 순회
		postorder((String)keyArray[0]);
		// 왼쪽 끝 노드를 찾은 다음 오른쪽, 부모 노드에 대해 순서대로 재귀 호출
		
		preorderResult.stream().forEach(x -> {
			try {
				bw.write(x + "");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		bw.write("\n");
		
		inorderResult.stream().forEach(x -> {
			try {
				bw.write(x + "");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		bw.write("\n");
		
		postorderResult.stream().forEach(x -> {
			try {
				bw.write(x + "");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		bw.write("\n");
		
		bw.flush();
		bw.close();
	}
	private static void postorder(String node) {
		String[] childArray = tree.get(node);
		
		if(childArray[0] != null)
			postorder(childArray[0]);
		if(childArray[1] != null)
			postorder(childArray[1]);
		
		postorderResult.add(node);
		
	}
	private static void inorder(String node) {
		String[] childArray = tree.get(node);
		
		if(childArray[0] != null) {
			inorder(childArray[0]);
		}
		
		inorderResult.add(node);
		if(childArray[1] != null) {
			inorder(childArray[1]);
		}
	}
	private static void preorder(String node) {
		preorderResult.add(node);
		
		String[] childArray = tree.get(node);
		if(childArray[0] != null) {
			preorder(childArray[0]);
		}
		
		if(childArray[1] != null) {
			preorder(childArray[1]);
		}
		
	}
}
