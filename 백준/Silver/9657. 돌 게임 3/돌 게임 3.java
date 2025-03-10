import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] dp = new int[N+1];
		for(int i=1; i<=N; i++) {
			if( i <= 4 ) {
				if( i == 2 ) dp[i] = 2;
				else dp[i] = 1;
			} else {
				int num = Math.max(dp[i-1], Math.max(dp[i-3], dp[i-4])) + 1;
				dp[i] = num % 2 == 0 ? 2 : 1;
			}
		}
		
		System.out.println(dp[N] % 2 == 0 ? "CY" : "SK");
	}

}
