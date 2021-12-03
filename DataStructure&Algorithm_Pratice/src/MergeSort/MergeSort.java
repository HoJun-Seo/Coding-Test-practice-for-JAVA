package MergeSort;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(3);
		list.add(6);
		list.add(17);
		list.add(1);
		list.add(9);
		list.add(5);
		list.add(4);
		
		System.out.println(splitAndmerge(list).toString());
	}

	private static List<Integer> splitAndmerge(List<Integer> list) {
		if(list.size() <= 1)
			return list;
		
		int half = list.size() / 2;
		List<Integer> leftList = splitAndmerge(list.subList(0, half));
		List<Integer> rightList = splitAndmerge(list.subList(half, list.size()));
		
		return listMerge(leftList, rightList);
	}

	private static List<Integer> listMerge(List<Integer> leftList, List<Integer> rightList) {
		List<Integer> mergeList = new ArrayList<Integer>();
		
		int leftIndex = 0; int rightIndex = 0;
		while(leftList.size() > leftIndex && rightList.size() > rightIndex) {
			
			int leftElement = leftList.get(leftIndex);
			int rightElement = rightList.get(rightIndex);
			
			if(leftElement > rightElement) {
				mergeList.add(rightElement);
				rightIndex++;
			}
			else {
				mergeList.add(leftElement);
				leftIndex++;
			}
		}
		
		while(leftList.size() > leftIndex) {
			mergeList.add(leftList.get(leftIndex));
			leftIndex++;
		}
		
		while(rightList.size() > rightIndex) {
			mergeList.add(rightList.get(rightIndex));
			rightIndex++;
		}
		return mergeList;
	}
}
