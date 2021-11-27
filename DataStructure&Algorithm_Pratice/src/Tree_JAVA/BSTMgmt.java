package Tree_JAVA;

public class BSTMgmt {
	
	private Node head;
	
	public BSTMgmt(Node head) {
		this.head = head;
	}
	
	public void insert(int value) {
		Node currentNode = this.head; // 루트 노드에서 부터 시작
		
		while(true) {
			if(value < currentNode.getValue()) { // 삽입하고자 하는 값이 현재 노드의 데이터 보다 작은 경우
				// 현재 노드의 왼쪽 Branch 에 노드가 있는지 확인
				if(currentNode.getLeft() != null) { 
					// 왼쪽 노드가 있을 경우 비교 대상을 현재 노드의 왼쪽 노드로 바꿔준다.
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
					// 오르쫀 노드가 존재한 다면 비교 대상을 오른쪽 노드로 변경해준다.
					currentNode = currentNode.getRight();
				}
				else {
					// 오른쪽 노드가 존재하지 않는다면 오른쪽 노드로서 삽입해준다.
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
	
	public boolean delete(int value) {
		
		// 노드가 있는지 부터 확인
		boolean searched = false;
		Node currentNode = this.head;
		Node parent = this.head;
		while (currentNode != null){
			if(currentNode.getValue() == value) {
				searched = true;
				break;
			}
			else if(value < currentNode.getValue()) {
				parent = currentNode;
				currentNode = currentNode.getLeft();
			}
			else {
				parent = currentNode;
				currentNode = currentNode.getRight();
			}	
		}
		
		if(searched == false)
			return false;
		
		// 노드가 존재하는 것이 확인 되었을 경우
		// 해당 노드가 Leaf Node 인 경우
		if(currentNode.getLeft() == null && currentNode.getRight() == null) {
			if(value < parent.getValue()) // 부모 노드 보다 값이 작으면(부모 노드의 왼쪽에 있으면)
				parent.setLeft(null);
			else
				parent.setRight(null);
		}
		
		// 해당 노드가 왼쪽 Child Node 를 가지고 있을 경우
		if(currentNode.getLeft() != null && currentNode.getRight() == null) {
			if(value < parent.getValue())  // 부모 노드의 왼쪽에 있을 경우
				parent.setLeft(currentNode.getLeft());
			else // 부모 노드의 오른쪽에 있을 경우
				parent.setRight(currentNode.getLeft());
		}
		// 해당 노드가 오른쪽 Child Node 를 가지고 있을 경우
		else if(currentNode.getLeft() == null && currentNode.getRight() != null) {
			if(value < parent.getValue()) 
				parent.setLeft(currentNode.getRight());
			else
				parent.setRight(currentNode.getRight());
		}
		
		// 해당 노드가 두개의 Child Node 를 가지고 있는 경우(중요)
		// 첫번째로 삭제할 Node 가 Parent Node 의 왼쪽에 있을 경우
		// 기본 사용 가능 전략
		// 1. 삭제할 Node 의 오른쪽 자식 중 가장 작은 값을, 삭제할 Node 의 Parent Node 가 가리키도록 한다.
		// 2. 삭제할 Node 의 왼쪽 자식 중 가장 큰 값을, 삭제할 Node 의 Parent Node 가 가리키도록 한다.
		// 위의 전략 중 1번 전략을 사용한다.
		// 여기에서 경우의 수가 다시 두 갈래로 갈린다.
		// 1-1 삭제할 Node 가 Parent Node 의 왼쪽에 있고, 삭제할 Node 의 오른쪽 자식 중
		// 가장 작은 값을 가진 Node 의 Child Node 가 없을 때
		// 즉, 삭제할 노드의 오른쪽에서 왼쪽 끝에 있는 노드가 Leaf Node 일 때 - 오른쪽 노드를 따로 가지고 있지 않을 때
		// 1-2 삭제할 Node 가 Parent Node 의 왼쪽에 있고, 삭제할 Node 의 오른쪽 자식 중
		// 가장 작은 값을 가진 Node 의 오른쪽에 Child Node 가 있을 때
		
		// 삭제할 Node 가 두개의 노드를 가지고 있을 때
		if(currentNode.getLeft() != null && currentNode.getRight() != null) {
			Node changeNode = null;
			Node changeNode_Parent = null;
			// 삭제할 Node 가 부모 노드의 왼쪽에 있을 경우
			if(value < parent.getValue()) {
				changeNode = currentNode.getRight(); // 삭제할 노드의 오른쪽에서 부터 시작
				changeNode_Parent = currentNode.getRight();
				
				// 삭제할 노드의 오른쪽에서 부터 가장 작은 값을 찾는다.
				while(changeNode.getLeft() != null) {
					changeNode_Parent = changeNode;
					changeNode = changeNode.getLeft();
				}
				
				// 가장 작은 노드가 오른쪽 노드를 가지고 있는 경우
				if(changeNode.getRight() != null){
					changeNode_Parent.setLeft(changeNode.getRight());
					// 오른쪽 노드를 가작 작은 값을 가진 노드가 있던 위치로 옮겨준다.(부모 노드와의 연결)
				}
				else // 오른쪽 노드를 가지고 있지 않은 경우
					// 오른쪽에서 가장 작은 노드와, 그 부모 노드와의 연결을 끊어준다.
					changeNode_Parent.setLeft(null);
				
				// 오른쪽에서 가장 작은 값을 가진 노드를 삭제한 데이터의 위치로 올려준다.
				parent.setLeft(changeNode);
				// 삭제한 노드가 가지고 있는 자식 노드들의 정보를 적재해준다.
				changeNode.setLeft(currentNode.getLeft());
				// 오른쪽 노드에서 왼쪽으로 한번이라도 이동 했을 경우
				// 즉, 가장 작은 값을 찾기 위해 왼쪽으로 한번이라도 이동 했을 경우
				if(currentNode.getRight() == changeNode) {
					changeNode.setRight(currentNode.getRight());
				}
				// 왼쪽으로 한번도 가지 않고 오른쪽에 있던 노드가 오른쪽에서 가장 작은 노드였을 경우엔,
				// 오른쪽 노드의 위치를 삭제한 노드의 위치로 옮겨주되, 해당 노드의 오른쪽 노드에 연결된 정보는 
				// 삭제된 노드의 오른쪽 노드 정보를 적재 시키지 않고 그대로 유지시켜 준다.
				// 만약 삭제한 노드의 오른쪽 노드 정보를 본래 오른쪽 노드였던 노드에게 적재시켜 줄 경우
				// 삭제한 노드의 위치로 옮겨온 오른쪽 노드가 가리키고 있는 자신의 오른쪽 노드에 대한 정보가
				// 자기자신을 가리키게 되므로 반드시 문제가 발생하게 된다.
			}
			// 삭제할 노드가 부모 노드의 오른쪽에 있을 경우
			else {
				changeNode = currentNode.getRight(); 
				changeNode_Parent = currentNode.getRight(); 
				while(changeNode.getLeft() != null) {
					changeNode_Parent = changeNode;
					changeNode = changeNode.getLeft();
				}
				
				if(changeNode.getRight() != null) {
					changeNode_Parent.setLeft(changeNode.getRight());
				}
				else
					changeNode_Parent.setLeft(null);
				
				parent.setRight(changeNode);
				changeNode.setLeft(currentNode.getLeft());
				// 오른쪽 노드에서 한번이라도 왼쪽으로 이동한 경우
				if(currentNode.getRight() == changeNode) {
					changeNode.setRight(currentNode.getRight());
				}
				
			}
			currentNode = null; // gc 에 의해 자동으로 정리된다.
			parent = null; // gc 에 의해 자동으로 정리된다.
		}		
		return true;		
	}
}
