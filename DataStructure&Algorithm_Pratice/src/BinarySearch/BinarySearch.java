package BinarySearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarySearch {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(3);
		list.add(6);
		list.add(17);
		list.add(1);
		list.add(9);
		list.add(5);
		list.add(4);
		
		Collections.sort(list);
		
		System.out.println(binarySearch(list, 17));
	}
	
	private static boolean binarySearch(List<Integer> list, int search) {
		
		if(list.size() == 1 && search == list.get(0))
			return true;
		
		if(list.size() == 1 && search != list.get(0))
			return false;
		
		if(list.size() == 0)
			return false;
		
		int middle = list.size() / 2;
		if(search == list.get(middle))
			return true;
		else {
			if(search > list.get(middle))
				return binarySearch(list.subList(middle, list.size()), search);
			else {
				return binarySearch(list.subList(0, middle), search);
			}
		}
	}
}
