package BubbleSort;

public class BubbleSort {
	
	private int[] array;
	
	public BubbleSort(int[] array) {
		this.array = array;
	}
	
	public int[] bubbleSort() {
		
		for(int i = 0; i < this.array.length - 1; i++) {
			boolean swap = false;
			for(int index = 0; index < this.array.length - i - 1; index++) {
				if(this.array[index] > this.array[index + 1]) {
					int temp = this.array[index + 1];
					this.array[index + 1] = this.array[index];
					this.array[index] = temp;
					
					swap = true;
				}
			}
			
			if(!swap)
				break;
		}
		
		return this.array;
	}
}
