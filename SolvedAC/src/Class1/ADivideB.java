package Class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ADivideB {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str_aplusb = br.readLine().split(" ");
		System.out.println(Double.parseDouble(str_aplusb[0]) / Double.parseDouble(str_aplusb[1]));
 	}
}
