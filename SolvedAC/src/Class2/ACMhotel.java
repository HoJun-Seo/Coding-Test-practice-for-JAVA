package Class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ACMhotel {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		List<String[]> hotelList = new ArrayList<String[]>();
		
		for(int i = 0; i < count; i++) {
			hotelList.add(br.readLine().split(" "));
		}
		
		
		for(int i = 0; i < hotelList.size(); i++) {
			String[] str_acmHotel = hotelList.get(i);
			int[] acmHotel = new int[str_acmHotel.length];
			
			for(int index = 0; index < str_acmHotel.length; index++) {
				acmHotel[index] = Integer.parseInt(str_acmHotel[index]);
			}
			
			int yy = acmHotel[2];
			int xx = 1;
			
			while(acmHotel[2] > acmHotel[0]) {
				acmHotel[2] -= acmHotel[0];
				yy = acmHotel[2];
				xx++;
			}
			
			String YY = String.valueOf(yy);
			String XX = "";
			if(xx < 10)
				XX += "0";
			XX += String.valueOf(xx);
			
			String result = YY + XX;
			System.out.println(result);
		}
	}
}
