package InsertionSort;

public class InsertionSort {
	
	private int[] array;
	
	public InsertionSort(int[] array) {
		this.array = array;
	}
	
	public int[] insertionSort() {
		
		for(int i = 0; i < this.array.length-1; i++) {
			for(int index = i + 1; index > 0; index--) {
				if(this.array[index] < this.array[index-1]) {
					int temp = this.array[index-1];
					this.array[index-1] = this.array[index];
					this.array[index] = temp;
				}
				else
					break;
			}
		}
		
		return this.array;
	}
}
