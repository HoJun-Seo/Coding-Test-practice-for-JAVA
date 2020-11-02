package Character_Numbers;


public class Solution4 {
	public static void main(String[] args) {
		String s = "try hello world";
		String answer = "";
        
        String[] string_array = s.split(" ");
        for(int i = 0; i < string_array.length; i++) {
        	char[] char_array = string_array[i].toCharArray();
        	for(int j = 0; j < char_array.length; j++) {
        		if(j % 2 == 0 && char_array[j] >= 97 && char_array[j] <= 122) {
        			char_array[j] = (char)(char_array[j] - 32);
        		}
        		
        		else if(j % 2 == 0 && char_array[j] >= 65 && char_array[j] <= 90) {
        			char_array[j] = (char)(char_array[j] + 32);
        		}
        	}
        	answer += String.valueOf(char_array) + " ";
        }
        
        System.out.println(answer);
	}
}
