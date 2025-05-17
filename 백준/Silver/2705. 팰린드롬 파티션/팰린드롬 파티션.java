import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int[][] dp = new int[1001][2];
		dp[1][0] = 1;
		dp[2][0] = 1;
		dp[2][1] = 1;
		for(int i=3; i<=1000; i++) {
			if( i % 2 == 0 ) {
				dp[i][0] = dp[i-1][0];
				dp[i][1] = dp[i/2][0] + dp[i/2][1];
			} else {
				dp[i][0] = dp[i-1][0] + dp[i-1][1];
			}
		}
		
		
		int T = Integer.parseInt(br.readLine());
		for(int i=0; i<T; i++) {
			int N = Integer.parseInt(br.readLine());
			
			sb.append(dp[N][0]+dp[N][1]+"\n");
		}
		System.out.println(sb.toString());
	}

}
