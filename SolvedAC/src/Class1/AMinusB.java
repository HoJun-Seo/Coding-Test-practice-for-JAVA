package Class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AMinusB {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str_aplusb = br.readLine().split(" ");
		System.out.println(Integer.parseInt(str_aplusb[0]) - Integer.parseInt(str_aplusb[1]));
 	}
}
