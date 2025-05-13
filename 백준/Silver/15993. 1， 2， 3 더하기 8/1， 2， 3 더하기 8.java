import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());

		int MOD = 1000000009;
		long[][] dp = new long[100001][2];
		
		dp[1][0] = 1;
		dp[1][1] = 0;
		dp[2][0] = 1;
		dp[2][1] = 1;
		dp[3][0] = 2;
		dp[3][1] = 2;
		
		for(int i=4; i<=100000; i++) {
			dp[i][0] = (dp[i-1][1] + dp[i-2][1] + dp[i-3][1]) % MOD;
			dp[i][1] = (dp[i-1][0] + dp[i-2][0] + dp[i-3][0]) % MOD;
		}
		for(int tc=0; tc<T; tc++ ) {
			int N = Integer.parseInt(br.readLine());
			
			sb.append(dp[N][0]+" "+dp[N][1]+"\n");
		}
		System.out.println(sb.toString());
	}

}
