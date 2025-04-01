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
			
			String str1 = st.nextToken();
			String str2 = st.nextToken();
			
			int N = str1.length();
			int M = str2.length();
			int[][] dp = new int[N+1][M+1];
			
			int max = 0;
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=M; j++) {
					if( str1.charAt(i-1) == str2.charAt(j-1) ) {
						dp[i][j] = dp[i-1][j-1] + 1;
					} else {
						dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
					}
					max = Math.max(max, dp[i][j]);
				}
			}
			
			System.out.printf("#%d %d\n", tc, max);
		}
	}

}
