import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long[] dp = new long[101];
		for(int i=1; i<=100; i++) {
			if( i <= 3 ) {
				dp[i] = 1;
			} else {
				dp[i] = dp[i-2] + dp[i-3];
			}
		}
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			System.out.printf("#%d %d\n", tc, dp[N]);
		}
	}

}
