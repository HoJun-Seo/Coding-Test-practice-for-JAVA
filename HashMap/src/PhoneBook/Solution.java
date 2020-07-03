package PhoneBook;

import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public boolean solution(String[] phone_book) {
    	HashMap<Integer, String> phoneHash = new HashMap<Integer, String>();
    	boolean answer = true;
    	int index = 0;
    	for(int i = 0; i < phone_book.length; i++) {
    		phoneHash.put(i, phone_book[i]);
    	}
    	int[] array_length = new int[phone_book.length];
    	for(int i = 0; i < phoneHash.size(); i++) {
    		array_length[i] = phoneHash.get(i).length();
    	}
    	Arrays.sort(array_length);
    	for(int i = 0; i < phoneHash.size(); i++) {
    		if(array_length[0] == phoneHash.get(i).length()) {
    			index = i;
    			break;
    		}
    	}
    	
    	for(int i = 0; i < phoneHash.size(); i++) {
    		if(index == i) continue;
    		else if(phoneHash.get(index).contains(phoneHash.get(i).substring(0, phoneHash.get(index).length()))) {
    			answer = false;
    			break;
    		}
    	}
        return answer;
    }
}
