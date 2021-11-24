package Tree_JAVA;

public class BSTMgmt {
	
	private Node head;
	
	public BSTMgmt(Node head) {
		this.head = head;
	}
	
	public void insert(int value) {
		Node currentNode = this.head;
		
		while(true) {
			if(value < currentNode.getValue()) {
				// 현재 노드의 왼쪽 Branch 에 노드가 있는지 확인
				if(currentNode.getLeft() != null) { 
					// 비교 대상을 현재 노드의 왼쪽 노드로 바꿔준다.
					currentNode = currentNode.getLeft();
				}
				else {
					// 왼쪽 노드가 존재하지 않는다면 왼쪽 노드로서 삽입해준다.
					currentNode.setLeft(new Node(value));
					System.out.println("값이 정상적으로 삽입 되었습니다.");
					System.out.println();
					break;
				}
			}
			else { // 넣고자 하는 value 값이 현재 노드와 크기가 같거나 큰 경우
				if(currentNode.getRight() != null) {
					currentNode = currentNode.getRight();
				}
				else {
					currentNode.setRight(new Node(value));
					System.out.println("값이 정상적으로 삽입 되었습니다.");
					System.out.println();
					break;
				}
			}
			
		}
	}
	
	// 이진 탐색 트리(BST) 에 특정 노드가 있는지 없는지 확인하는 메소드
	public void search(int value) {
		Node currentNode = this.head;
		boolean search = false;
		
		while(currentNode != null) {
			if(currentNode.getValue() == value) {
				search = true;
				break;
			}
			else if(value < currentNode.getValue()) {
				currentNode = currentNode.getLeft();
			}
			else
				currentNode = currentNode.getRight();
		}
		
		if(search) {
			System.out.println(value + " 값이 존재합니다. ");
			System.out.println();
		}
		else {
			System.out.println("값이 존재하지 않습니다.");
			System.out.println();
		}
	}
}
