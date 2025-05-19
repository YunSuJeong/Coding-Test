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
			
			int len = str.length();
			for(int i=1; i<=len; i++) {
				char c = str.charAt(len-i);
				if( c == 'b' || c == 'd' ) {
					sb.append(c == 'b' ? 'd' : 'b');
				} else {
					sb.append(c == 'p' ? 'q' : 'p');
				}
			}
			System.out.printf("#%d %s\n", tc, sb.toString());
			sb.setLength(0);
		}
		
	}

}
