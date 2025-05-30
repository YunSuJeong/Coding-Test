import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int MOD = 1000000007;
		
		int[] dp = new int[N+1];
		for(int i=1; i<=N; i++) {
			if( i <= M ) {
				if( i == M ) dp[i] = 2;
				else dp[i] = 1;
			} else {
				dp[i] = (dp[i-1] + dp[i-M]) % MOD;
			}
		}
		System.out.println(dp[N]);
	}

}
