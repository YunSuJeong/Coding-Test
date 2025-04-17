import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			String word = br.readLine();
			
			int cnt = word.length();
			for(int i=0; i<word.length(); i++) {
				char c = word.charAt(i);
				if( c - 97 != i ) {
					cnt = i;
					break;
				}
			}
			System.out.printf("#%d %d\n", tc, cnt);
		}
	}

}
