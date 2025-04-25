import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int MOD = 1000000007;

		long[] dp = new long[1000001];
		dp[1] = 3;
		dp[2] = 8;
		for(int i=3; i<=N; i++) {
			dp[i] = (dp[i-1] * 2 % MOD + dp[i-2] * 2 % MOD) % MOD;
		}
		System.out.println(dp[N]);
	}

}
