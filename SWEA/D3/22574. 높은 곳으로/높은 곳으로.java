import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			
			int[][] dp = new int[N+1][2];
			for(int i=1; i<=N; i++) {
				if( i == 1 ) {
					dp[i][0] = 0;						// 현재층에서 머무를 때, 현재까지 최대 높이
					dp[i][1] = i == P ? 0 : i;			// +i층으로 갈 때, 최대높이
				} else {
					dp[i][0] = dp[i-1][0] + i == P ? dp[i-1][0] : dp[i-1][0] + i;
					dp[i][1] = dp[i-1][1] + i == P ? dp[i-1][1] : dp[i-1][1] + i;
				}
			}
			System.out.println(Math.max(dp[N][0], dp[N][1]));
		}
	}

}