package Class2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class LANlineCut {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] inputArray = br.readLine().split(" ");
		int curline = Integer.parseInt(inputArray[0]);
		int reqline = Integer.parseInt(inputArray[1]);
		long[] lineArray = new long[curline];

		long max = 0;
		for(int i = 0; i < curline; i++){

			long length = Long.parseLong(br.readLine());
			lineArray[i] = length;
			if(max < length)
				max = length;
		}

		long start = 1;
		long end = max+1;
		long mid = 0;
		while(start+1 < end){
			mid = (start + end) / 2;

			long sum = 0;
			for(int i = 0; i < lineArray.length; i++){
				long line = lineArray[i];

				long cutCount = line/mid;
				sum += cutCount;
			}

			if(sum < reqline){
				end = mid;
			}
			else{
				start = mid;
			}
		}

		bw.write(start + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
