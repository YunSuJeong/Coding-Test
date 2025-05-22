import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long MOD = 1000000007;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			String word = br.readLine();
			
			long cnt = 0;
			for(int i=0; i<word.length(); i++) {
				if( i == 0 ) {
					if( word.charAt(i) == word.charAt(i+1) ) cnt = 1;
					else cnt = 2;
				} else if( i == word.length()-1 ) {
					if( word.charAt(i) != word.charAt(i-1) ) cnt = cnt * 2 % MOD;
				} else {
					if( word.charAt(i-1) == word.charAt(i) && word.charAt(i) == word.charAt(i+1) && word.charAt(i-1) == word.charAt(i+1) ) {
						continue;
					} else if( word.charAt(i-1) != word.charAt(i) && word.charAt(i) != word.charAt(i+1) && word.charAt(i-1) != word.charAt(i+1) ) {
						cnt = cnt * 3 % MOD;
					} else {
						cnt = cnt * 2 % MOD;
					}
				}
			}
			System.out.printf("#%d %d\n", tc, cnt);
		}
	}

}
