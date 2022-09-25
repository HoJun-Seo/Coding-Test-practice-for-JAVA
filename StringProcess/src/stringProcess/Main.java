package stringProcess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String[] str_num = str.trim().split(" ");
		if(str.charAt(0) == ' ' && str.length() == 1) System.out.println(0);
		else System.out.println(str_num.length);
		br.close();
	}
}
