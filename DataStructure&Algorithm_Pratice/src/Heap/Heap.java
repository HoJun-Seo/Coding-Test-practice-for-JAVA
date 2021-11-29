package Heap;

import java.util.ArrayList;
import java.util.List;

public class Heap {
	private List<Integer> heapArray;
	
	public Heap(int data) {
		this.heapArray = new ArrayList<Integer>();
		this.heapArray.add(null);
		this.heapArray.add(data);
	}
	
	// 힙 트리 데이터 추가
	public boolean insert(int data) {
		
		// 방어 코드 : 힙 배열에 아무 데이터도 들어가 있지 않은 상태에서 
		// 메소드가 수행되는 경우를 대비하여 리스트에 데이터 값을 적재해주는 코드를 작성해준다.
		if(this.heapArray.size() == 0) {
			this.heapArray.add(null);
			this.heapArray.add(data);
			
			return true;
		}
		
		// ArrayList 에서 add 라는 메소드 자체가 리스트의 가장 마지막 부분에 
		// 데이터를 추가해주는 것이기 때문에 힙 트리의 마지막 요소에 데이터를 추가해주기 위해
		// 굳이 추가적인 로직을 더 작성해줄 필요가 없다.
		// 연결리스트를 구조를 직접 구현하면서 트리를 만들고 있는것이 아니라, ArrayList 를 통해
		// 트리를 만들고 있기 때문에 얻을 수 있는 장점이다.
		this.heapArray.add(data);
		
		// 삽입한 데이터가 부모 노드보다 값이 클 경우의 로직을 작성해준다.
		
		// 마지막으로 삽입한 데이터의 인덱스를 알아낸다.
		int insertedIdx = this.heapArray.size() - 1; 
		while(moveUp(insertedIdx)) {
			// moveUp 메소드 실행결과 true 를 반환하면 계속 반복문을 수행한다.
			
			// 삽입된 데이터의 노드의 부모 노드 인덱스를 알아낸다.
			int parentIdx = insertedIdx / 2;
			
			// 부모 노드와 삽입된 데이터 노드의 위치를 바꿔준다.
			int temp = this.heapArray.get(insertedIdx);
			this.heapArray.set(insertedIdx, this.heapArray.get(parentIdx));
			this.heapArray.set(parentIdx, temp);
			
			insertedIdx = parentIdx;
		}
		return true;
	}
	
	// 삽입된 데이터가 부모 노드보다 큰지 작은지에 대한 검증 결과를 반환해주는 메소드를 작성해준다.
	private boolean moveUp(int insertedIdx) {
		// 삽입된 데이터가 루트 노드까지 올라갔을 경우
		// 더 이상 데이터 비교 및 위치 스왑 작업을 해줄 필요가 없다.
		if(insertedIdx <= 1) 
			return false;
		
		int parentIdx = insertedIdx / 2;
		// 삽입된 노드의 데이터가 부모 노드의 데이터 보다 큰 경우 true 를 반환시켜 반복문을 수행시킨다.
		if(this.heapArray.get(insertedIdx) > this.heapArray.get(parentIdx)) {
			return true;
		}
		else
			return false;
	}
	
	// 힙 트리 데이터 삭제 - 최대값(Root Node)
	public int pop() {
		
		// Root Node 데이터 적재
		int returnedData = this.heapArray.get(1);
		// 힙에 마지막으로 들어온 데이터를 Root Node 로 올려준다.
		this.heapArray.set(1, this.heapArray.get(this.heapArray.size()-1));
		// 마지막으로 힙 트리에 들어온 노드가 있던 위치의 노드를 삭제헤준다.
		this.heapArray.remove(this.heapArray.size()-1);
		// Root Node 와 자식 노드간 위치 변경이 필요한 경우를 위해 
		// Root Node 의 인덱스를 따로 적재해준다. 
		int popedIdx = 1;
		
		// moveDown 메소드 실행결과 true 를 반환하면 계속 반복문을 수행한다.
		while(moveDown(popedIdx)) {
			int leftChildIdx = popedIdx * 2;
			int rightChildIdx = popedIdx * 2 + 1;
			
			// Leaf Node 인 경우 moveDown 메소드의 반환값이 false 가 되어
			// 반복문이 수행되지 않으므로 고려하지 않는다.
			
			// 어떤 로직에 의해 moveDown 메소드가 true 를 반환했는지 모르기 때문에
			// 반복문에서 각 로직 별로 코드를 다시 작성해준다.
			
			// 오른쪽 자식 노드만 없을 경우(왼쪽 자식 노드만 있을 경우)
			if(rightChildIdx >= this.heapArray.size()) {
				// 왼쪽 노드의 값이 부모 노드보다 큰 경우 위치를 바꿔준다.
				if(this.heapArray.get(popedIdx) < this.heapArray.get(leftChildIdx)) {
					int temp = this.heapArray.get(leftChildIdx);
					this.heapArray.set(leftChildIdx, this.heapArray.get(popedIdx));
					this.heapArray.set(popedIdx, temp);
					
					popedIdx = leftChildIdx;
				}
			}
			// 왼쪽, 오른쪽 자식 노드가 모두 존재할 경우
			else {
				if(this.heapArray.get(leftChildIdx) > this.heapArray.get(rightChildIdx)) {
					if(this.heapArray.get(popedIdx) < this.heapArray.get(leftChildIdx)) {
						int temp = this.heapArray.get(leftChildIdx);
						this.heapArray.set(leftChildIdx, this.heapArray.get(popedIdx));
						this.heapArray.set(popedIdx, temp);
						
						popedIdx = leftChildIdx;
					}
				}
				else {
					if(this.heapArray.get(popedIdx) < this.heapArray.get(rightChildIdx)) {
						int temp = this.heapArray.get(rightChildIdx);
						this.heapArray.set(rightChildIdx, this.heapArray.get(popedIdx));
						this.heapArray.set(popedIdx, temp);
						
						popedIdx = rightChildIdx;
					}
				}
			}
		}
		
		return returnedData;
	}

	// 자식 노드가 부모 노드보다 큰지 작은지에 대한 검증 결과를 반환해주는 메소드를 작성해준다.
	private boolean moveDown(int popedIdx) {
		
		// 왼쪽 자식 노드와 오른쪽 자식 노드의 인덱스를 알아낸다.
		int leftChildIndex = popedIdx * 2;
		int rightChildIndex = popedIdx * 2 + 1;
		
		// case 1 : 왼쪽 자식노드 조차 존재하지 않을 때(Child Node 를 가지고 있지 않을 때(Leaf Node))
		// 왼쪽 자식 노드 인덱스에 대한 계산결과가 리스트의 길이를 넘어가는 경우
		if(leftChildIndex >= this.heapArray.size())
			return false;
		
		// case 2 : 오른쪽 자식노드만 존재하지 않을 때(왼쪽 자식 노드가 존재함)
		// 오른쪽 자식 노드 인덱스에 대한 계산결과가 리스트의 길이를 넘어가는 경우
		else if(rightChildIndex >= this.heapArray.size()) {
			// 왼쪽 자식 노드가 부모 노드보다 클 경우 위치를 바꿔주어야 한다.
			if(this.heapArray.get(popedIdx) < this.heapArray.get(leftChildIndex))
				return true;
			else
				return false;
		}
		
		// case 3 : 두 개의 자식 노드를 모두 가지고 있을 때
		else {
			// 왼쪽 자식 노드가 오른쪽 자식 노드보다 큰 경우
			if(this.heapArray.get(leftChildIndex) > this.heapArray.get(rightChildIndex)) {
				// 왼쪽 자식 노드가 부모 노드 보다 큰 경우 위치를 바꿔주어야 한다.
				if(this.heapArray.get(popedIdx) < this.heapArray.get(leftChildIndex))
					return true;
				else
					return false;
			}
			// 오른쪽 자식 노드가 왼쪽 자식 노드보다 크거나 같을 경우
			else {
				// 오른쪽 자식 노드가 부모 노드보다 큰 경우 위치를 바꿔주어야 한다.
				if(this.heapArray.get(popedIdx) < this.heapArray.get(rightChildIndex))
					return true;
				else
					return false;
			}
		}
	}

	public List<Integer> getHeapArray() {
		return heapArray;
	}
}
