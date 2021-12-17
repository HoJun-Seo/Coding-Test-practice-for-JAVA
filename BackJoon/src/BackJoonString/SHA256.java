package BackJoonString;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256 {
	public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(str.getBytes());
		
		byte[] bytes = md.digest();
		for(byte b : bytes) {
			bw.write(String.format("%02x", b));
		}
		bw.write("\n");
		bw.flush();
		bw.close();
	}
}
