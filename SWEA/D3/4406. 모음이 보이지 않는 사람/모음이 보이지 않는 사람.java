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
			
			for(int i=0; i<str.length(); i++) {
				char c = str.charAt(i);
				
				if( c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u' ) {
					sb.append(c);
				}
			}
			System.out.printf("#%d %s\n", tc, sb.toString());
			sb.setLength(0);
		}
	}

}
