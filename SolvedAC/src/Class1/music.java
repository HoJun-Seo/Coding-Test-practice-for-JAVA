package Class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class music {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] music = br.readLine().split(" ");
		String result = "";
		
		if(!music[0].equals("1") && !music[0].equals("8")) 
			result = "mixed";
		else if(music[0].equals("1")) {
			for(int i = 1; i < music.length; i++) {
				if(music[i].equals(String.valueOf(i+1))) {
					result = "ascending";
				}else {
					result = "mixed";
					break;
				}
					
			}
		}
		else if(music[0].equals("8")) {
			for(int i = 1; i < music.length; i++) {
				if(music[i].equals(String.valueOf(Integer.parseInt(music[0])-i))) {
					result = "descending";
				}else {
					result = "mixed";
					break;
				}			
			}
		}
		System.out.println(result);
	}
}
