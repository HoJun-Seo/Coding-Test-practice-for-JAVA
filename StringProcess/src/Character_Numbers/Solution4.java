package Character_Numbers;


public class Solution4 {
	public static void main(String[] args) {
		String s = "try hello world";
		String answer = "";
        
        String[] string_array = s.split(" ");
        for(int i = 0; i < string_array.length; i++) {
        	for(int j = 0; j < string_array[i].length(); j++) {
        		if(j % 2 == 0) {
        			string_array[i] = string_array[i].replace(string_array[i].charAt(j), (char)(string_array[i].charAt(j) - 32));
        			System.out.println(string_array[i].charAt(j));
        		}	
        	}
        	System.out.println(string_array[i]);
        }
        
        for(int i = 0; i < string_array.length; i++) {
        	answer += string_array[i];
        	if(i != string_array.length - 1) answer += " ";
        }
        
        System.out.println(answer);
	}
}
