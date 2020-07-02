package PhoneBook;

import java.util.HashMap;

class Solution {
    public boolean solution(String[] phone_book) {
    	//전화번호부에 적힌 전화번호를 담은 배열 phone_book solution 함수의 매개변수로 주어진다.
    	//전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 경우가 있는지 확인한다.
    	//한 번호가 다른 번호의 접두어인 경우가 있는것이 확인 될 경우 false 를, 그렇지 않을 경우 true 를 반환한다.
    	//해쉬 맵을 이용하는 문제로서 배열에서 각 번호의 인덱스를 키 값, 해당 인덱스의 내용인 전화번호를 데이터로 하는 해쉬 맵을 생성하여 문제를 해결하자.
    	HashMap<Integer, String> phoneHash = new HashMap<Integer, String>();
    	for(int i = 0; i < phone_book.length; i++) {
    		phoneHash.put(i, phone_book[i]);
    	}
    	// 각 키값 별로 가지고 있는 값들의 문자열을 검사하여 한 문자열 전체가 다른 문자열의 접두어가 되는 경우가 있는지 검사하는 로직을 구축해야 한다.
    	// 길이가 가장 짧은 값을 알아낸 후, 해당 문자열의 길이 만큼 다른 문자열의 첫 인덱스 부터 해당되는 길이만큼 잘라낸 substring 과 비교하여 
    	// 한번 이라도 서로 값이 같은 경우가 있다면 false 반환, 그렇지 않으면 true 반환
    	// 상식적으로 다른 문자열의 접두어가 되려면 배열안에서 길이가 가장 짧은 문자열이어야 한다.
        boolean answer = true;
        return answer;
    }
}
