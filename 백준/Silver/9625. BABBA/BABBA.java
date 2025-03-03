import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int K = Integer.parseInt(br.readLine());
		
		// dp : i번 눌렀을 때, A와 B의 개수
		int[][] dp = new int[K+1][2];
		dp[0][0] = 1;			// dp[i][0] : A개수
		dp[0][1] = 0;			// dp[i][1] : B개수
		
		for(int i=1; i<=K; i++) {
			dp[i][0] = dp[i-1][1];
			dp[i][1] = dp[i-1][0] + dp[i-1][1];
		}
		
		System.out.println(dp[K][0]+" "+dp[K][1]);
		
	}

}
