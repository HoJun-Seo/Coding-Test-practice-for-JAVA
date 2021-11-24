package LinkedList_JAVA;

public class NodeMgmt {
	
	private Node head;
	
	// 연결리스트 헤더 노드 생성
	public NodeMgmt(int data) {
		this.head = new Node(data);
	}
	
	public void add(int data) {
		if(this.head == null) { 
			// 연결 리스트의 헤더가 생성되지 않은 상태일 경우
			// 헤더를 새로 생셍해준다.
			this.head = new Node(data);
		}
		else {
			// 가장 마지막 노드 뒤에 데이터를 추가해준다.
			Node node = this.head;
			while(node.getNext() != null) {
				node = node.getNext();
			}
			node.setNext(new Node(data));
		}
	}
	
	public void desc() {
		Node node = this.head;
		while(node != null) {
			System.out.println(node.getData());
			node = node.getNext();
		}
	}
	
	public void delete(int data) {
		
		boolean search = false;
		
		if(this.head == null) {
			System.out.println("연결 리스트가 존재하지 않은 상태입니다.");
			System.out.println("연결 리스트를 먼저 생성해 주십시오");
			System.out.println();
		}
		else if(this.head.getData() == data) {
			// 헤더를 삭제하는 경우
			Node temp = this.head;
			this.head = this.head.getNext();
			temp = null; 
			// 아무것도 참조하지 않는 객체는 GC(가비지 컬렉션) 의 대상이 되어
			// 메모리에서 자동으로 삭제된다.
			System.out.println("데이터가 정상적으로 삭제되었습니다.");
			System.out.println();
		}
		else {
			// 중간 노드, 또는 마지막 노드를 삭제할 경우
			Node node = this.head;
			
			while(node.getNext() != null) {
				if(node.getNext().getData() == data) {
					// 다음 탐색 데이터가 삭제하고자 하는 노드일 경우
					Node temp = node.getNext();
					node.setNext(node.getNext().getNext()); // 삭제된 노드가 가리키고 있던 주소를 적재
					temp = null;
					search = true;
					break;
				}
				else
					node = node.getNext();
			}
			
			if(search) {
				System.out.println("데이터가 정상적으로 삭제되었습니다.");
				System.out.println();
			}else {
				System.out.println("입력하신 데이터가 존재하지 않습니다.");
				System.out.println();
			}
		}
	}
}
