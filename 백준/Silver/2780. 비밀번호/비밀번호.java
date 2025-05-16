import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int[][] dp = new int[1001][10];
		int MOD = 1234567;
		for(int i=1; i<=1000; i++) {
			if( i == 1 ) {
				for(int j=0; j<10; j++) {
					dp[i][j] = 1;
				}
			} else {
				dp[i][0] = dp[i-1][7];
				dp[i][1] = (dp[i-1][2] + dp[i-1][4]) % MOD;
				dp[i][2] = (dp[i-1][1] + dp[i-1][3] + dp[i-1][5]) % MOD;
				dp[i][3] = (dp[i-1][2] + dp[i-1][6]) % MOD;
				dp[i][4] = (dp[i-1][1] + dp[i-1][5] + dp[i-1][7]) % MOD;
				dp[i][5] = (dp[i-1][2] + dp[i-1][4] + dp[i-1][6] + dp[i-1][8]) % MOD;
				dp[i][6] = (dp[i-1][3] + dp[i-1][5] + dp[i-1][9]) % MOD;
				dp[i][7] = (dp[i-1][4] + dp[i-1][8] + dp[i-1][0]) % MOD;
				dp[i][8] = (dp[i-1][5] + dp[i-1][7] + dp[i-1][9]) % MOD;
				dp[i][9] = (dp[i-1][6] + dp[i-1][8]) % MOD;
			}
		}
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=0; tc<T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			long sum = 0;
			for(int i=0; i<10; i++) {
				sum += dp[N][i];
			}
			sb.append(sum%MOD+"\n");
		}
		System.out.println(sb.toString());
	}

}
