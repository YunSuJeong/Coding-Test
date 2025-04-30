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
			StringTokenizer score = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int[] arr = new int[N];
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(score.nextToken());
			}
			
			int[][] dp = new int[K+1][N];
			for(int i=1; i<=K; i++) {
				for(int j=0; j<N; j++) {
					if( j == 0 ) dp[i][j] = arr[j];
					else dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j-1] + arr[j]);
				}
			}
			System.out.printf("#%d %d\n", tc, dp[K][N-1]);
		}
	}

}
