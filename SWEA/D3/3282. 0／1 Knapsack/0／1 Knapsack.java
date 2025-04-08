import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int[][] arr = new int[N+1][2];
			for(int i=1; i<=N; i++) {
				StringTokenizer thing = new StringTokenizer(br.readLine());
				
				int v = Integer.parseInt(thing.nextToken());
				int c = Integer.parseInt(thing.nextToken());
				
				arr[i][0] = v;
				arr[i][1] = c;
			}
			
			int[][] dp = new int[N+1][K+1];
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=K; j++) {
					if( j < arr[i][0] ) {
						dp[i][j] = dp[i-1][j];
					} else {
						dp[i][j] = Math.max(dp[i-1][j], arr[i][1] + dp[i-1][j-arr[i][0]]);
					}
				}
			}

			System.out.printf("#%d %d\n", tc, dp[N][K]);
		}
	}

}
