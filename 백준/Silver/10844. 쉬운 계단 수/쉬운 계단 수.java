import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int MOD = 1000000000;
		
		long[][] dp = new long[N+1][10];
		for(int i=1; i<=N; i++) {
			for(int j=0; j<10; j++) {
				if( i == 1 ) {
					if( j == 0 ) dp[i][j] = 0;
					else dp[i][j] = 1;
				} else {
					if( j == 0 || j == 9 ) {
						if( j == 0 ) dp[i][j] = dp[i-1][1];
						else dp[i][j] = dp[i-1][8];
					} else {
						dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % MOD;
					}
				}
			}
		}
		
		long sum = 0;
		for(int i=0; i<10; i++) {
			sum = (sum + dp[N][i]) % MOD;
		}
		System.out.println(sum);
	}

}
