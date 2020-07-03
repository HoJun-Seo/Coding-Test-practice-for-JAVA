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
    	Arrays.sort(phone_book);
    	for(int i = 0; i < phoneHash.size(); i++) {
    		if(phoneHash.get(i).startsWith(phone_book[0])) {
    			if(phoneHash.get(i).equals(phone_book[0])) answer = true;
    			else {
    				answer = false;
    				break;
    			}
    		}
    	}
        return answer;
    }
}
