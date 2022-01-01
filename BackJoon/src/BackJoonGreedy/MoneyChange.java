package BackJoonGreedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MoneyChange {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int money = 1000;
		int purchase = Integer.parseInt(br.readLine());
		
		int change = money-purchase;
		
		int moneycount = 0;
		
		while(change > 0) {
			if(change-500 >= 0) {
				change -= 500;
				moneycount++;
			}
			else if(change-100 >= 0) {
				int hundred = change/100;
				change -= (hundred*100);
				moneycount += hundred;
			}
			else if(change-50>=0) {
				int fifty = change/50;
				change -= (fifty*50);
				moneycount += fifty;
			}
			else if(change-10>=0) {
				int ten = change/10;
				change -= (ten*10);
				moneycount += ten;
			}
			else if(change-5>=0) {
				int five = change/5;
				change -= (five*5);
				moneycount += five;
			}
			else if(change-1 >= 0) {
				moneycount += change;
				change -= change;
			}
		}
		
		bw.write(moneycount + "\n");
		bw.flush();
		bw.close();
	}
}
