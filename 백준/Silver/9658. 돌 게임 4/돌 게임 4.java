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
				dp[i] = i % 2 == 0 ? 0 : 1;
			} else {
				dp[i] = Math.max(dp[i-1], Math.max(dp[i-3], dp[i-4])) == 1 ? 0 : 1;
			}
		}
		
		System.out.println(dp[N] == 1 ? "CY" : "SK");
	}

}
