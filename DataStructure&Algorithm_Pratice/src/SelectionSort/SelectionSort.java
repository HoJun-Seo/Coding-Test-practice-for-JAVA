package SelectionSort;

public class SelectionSort {
	
	private int[] array;
	
	public SelectionSort(int[] array) {
		this.array = array;
	}
	
	public int[] selectionSort() {
		
		for(int i = 0; i < this.array.length - 1; i++) {
			int lowest = i;
			for(int index = i + 1; index < this.array.length; index++) {
				if(this.array[lowest] > this.array[index]) 
					lowest = index;
			}
			// 최소값을 찾은 이후 기준 인덱스와 위치를 바꿔준다.
			int temp = this.array[lowest];
			this.array[lowest] = this.array[i];
			this.array[i] = temp;
		}
		
		return this.array;
	}
}
