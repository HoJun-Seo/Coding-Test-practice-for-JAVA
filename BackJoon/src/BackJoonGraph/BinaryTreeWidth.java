package BackJoonGraph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;


public class BinaryTreeWidth {
	
	static HashMap<Integer, BNode[]> tree = new HashMap<Integer, BNode[]>();
	static HashMap<Integer, List<BNode>> rank = new HashMap<Integer, List<BNode>>();
	static int width = 1;
	static int rankNumber = 1;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		HashMap<Integer, Integer> rootCheck = new HashMap<Integer, Integer>();
		int nodeCount = Integer.parseInt(br.readLine());
		
		StringTokenizer st = null;
		for(int i = 0; i < nodeCount; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int value = Integer.parseInt(st.nextToken());
			int leftValue = Integer.parseInt(st.nextToken());
			int rightValue = Integer.parseInt(st.nextToken());
			
			BNode node = new BNode(value);
			BNode[] childArray = new BNode[2];
			
			if(leftValue != -1) {
				BNode leftNode = new BNode(leftValue);
				childArray[0] = leftNode;
			}
			if(rightValue != -1) {
				BNode rightNode = new BNode(rightValue);
				childArray[1] = rightNode;
			}
			
			rootCheck.put(leftValue, 0);
			rootCheck.put(rightValue, 0);
			
			tree.put(node.getValue(), childArray);
		}
		
		// 중위 순회를 하되, 트리의 가장 왼쪽부터 너비 값을 1씩 증가시켜간다.(그냥 중위 순회 순서대로 너비값 주면 됨)
		// 그와 동시에 해당 노드의 레벨 값을 rank 해시맵에 넣어줘야 한다.
		
		// 루트가 1이 아닐수도 있기 때문에 무작정 정렬을 할게 아니라 일련의 과정을 통해 루트 노드를 찾아야 한다.
		// 부모 노드로 입력 받은 값들 중에 왼쪽 노드, 오른쪽 노드로 한번도 들어가본적이 없는 노드가 곧 루트 노드이다.
		int rootNumber = 0;
		Object[] keyArray = tree.keySet().toArray();
		for(int i = 0; i < keyArray.length; i++) {
			if(!rootCheck.containsKey((int)keyArray[i])) {
				rootNumber = (int)keyArray[i];
				break;
			}
		}
		
		inorder(rootNumber, rankNumber);
		
		// 각 높이 별로 너비 최소값과 최대값 간의 차이를 구한 후, 해당 값이 전체 너비 기준 최대값인지 판별한다.
		Object[] rankKey = rank.keySet().toArray();
		Arrays.sort(rankKey);
		List<Integer> widthList = new ArrayList<Integer>();
		for(int i = 0; i < rankKey.length; i++) {
			List<BNode> list = rank.get((int)rankKey[i]);
			
			int min = Collections.min(list).getWidth();
			int max = Collections.max(list).getWidth();
			
			widthList.add(max-min+1);
		}
		
		int maxWidth = Collections.max(widthList);
		int index = widthList.indexOf(maxWidth) + 1;
		
		bw.write(index + " " + maxWidth + "\n");
		bw.flush();
		bw.close();
		
	}
	private static void inorder(int node, int rankNumber) {
		BNode[] childArray = tree.get(node);
		
		if(childArray[0] != null)
			inorder(childArray[0].getValue(), rankNumber+1);
		
		if(rank.containsKey(rankNumber)) {
			List<BNode> list = rank.get(rankNumber);
			BNode bnode = new BNode(node);
			bnode.setWidth(width);
			list.add(bnode);
			rank.replace(rankNumber, list);
		}
		else {
			List<BNode> list = new ArrayList<BNode>();
			BNode bnode = new BNode(node);
			bnode.setWidth(width);
			list.add(bnode);
			rank.put(rankNumber, list);
		}
		
		width++;
		
		if(childArray[1] != null)
			inorder(childArray[1].getValue(), rankNumber+1);
		
	}
}

class BNode implements Comparable<BNode>{
	private int value;
	private int width;
	
	public BNode(int value) {
		this.value = value;
	}
	public int getValue() {
		return value;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	@Override
	public int compareTo(BNode o) {

		return this.width - o.getWidth();
	}
}
