import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			String str = br.readLine();
			
			int[] arr = new int[26];
			for(int i=0; i<str.length(); i++) {
				char c = str.charAt(i);
				arr[c-97]++;
			}
			
			for(int i=0; i<26; i++) {
				if( arr[i] > 0 ) arr[i] %= 2;
			}
			
			boolean flag = false;
			for(int i=0; i<26; i++) {
				for(int j=0; j<arr[i]; j++) {
					sb.append((char)(i+97));
					flag = true;
				}
			}
			System.out.printf("#%d %s\n", tc, flag ? sb.toString() : "Good");
			sb.setLength(0);
		}
	}

}
