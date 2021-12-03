package QuickSort;

import java.util.ArrayList;
import java.util.List;

public class QuickSort {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(3);
		list.add(6);
		list.add(17);
		list.add(1);
		list.add(9);
		list.add(5);
		list.add(4);
		
		System.out.println(qsort(list).toString());
	}

	private static List<Integer> qsort(List<Integer> list) {
		if(list.size() <= 1)
			return list;
		
		int pivot = list.get(0);
		
		List<Integer> leftList = new ArrayList<Integer>();
		List<Integer> rightList = new ArrayList<Integer>();
		
		for(int i = 1; i < list.size(); i++) {
			if(pivot > list.get(i))
				leftList.add(list.get(i));
			else
				rightList.add(list.get(i));
		}
		
		List<Integer> resultList = qsort(leftList);
		resultList.add(pivot);
		resultList.addAll(qsort(rightList));
		return resultList;
	}
}
