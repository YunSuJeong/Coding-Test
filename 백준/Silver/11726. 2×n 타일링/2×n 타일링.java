import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int MOD = 10007;
		
		int[] dp = new int[N+1];
		for(int i=1; i<=N; i++) {
			if( i < 3 ) {
				dp[i] = i;
			} else {
				dp[i] = (dp[i-2] + dp[i-1]) % MOD;
			}
		}
		System.out.println(dp[N]);
	}

}
