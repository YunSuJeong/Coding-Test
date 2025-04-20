import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		int MOD = 1000000009;
		long[] dp = new long[1000001];
		for(int i=1; i<=1000000; i++) {
			if( i < 4 ) {
				dp[i] = (long) Math.pow(2, i-1);
			} else {
				dp[i] = (dp[i-1] + dp[i-2] + dp[i-3]) % MOD;
			}
		}
		
		for(int i=0; i<T; i++) {
			int N = Integer.parseInt(br.readLine());
			
			sb.append(dp[N]+"\n");
		}
		System.out.println(sb.toString());
	}

}
