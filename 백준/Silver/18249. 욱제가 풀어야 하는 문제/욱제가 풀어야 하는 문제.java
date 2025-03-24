import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		int MOD = 1000000007;
		int[] dp = new int[191229];
		dp[0] = 1;
		dp[1] = 2;
		for(int i=2; i<191229; i++) {
			dp[i] = (dp[i-1] + dp[i-2]) % MOD;
		}
		
		for(int tc=0; tc<T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			sb.append(dp[N-1]+"\n");
		}
		System.out.println(sb.toString());
	}

}
