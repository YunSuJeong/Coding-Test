import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int MOD = 9901;
		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[N+1][3];
		
		for(int i=1; i<=N; i++) {
			if( i == 1 ) {
				dp[i][0] = dp[i][1] = dp[i][2] = 1;
			} else {
				dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % MOD;
				dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % MOD;
				dp[i][2] = (dp[i-1][0] + dp[i-1][1]) % MOD;
			}
		}
		System.out.println((dp[N][0] + dp[N][1] + dp[N][2]) % MOD);
	}

}
