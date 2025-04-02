import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		StringTokenizer S = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(S.nextToken());
		}
		
		int max = 0;
		int[][] dp = new int[K+1][N];
		
		dp[0][0] = arr[0] % 2 == 0 ? 1 : 0;
		// 어떤 홀수도 삭제하지 않은 상태에서 i번째 값까지 연속된 짝수 길이
		for(int i=1; i<N; i++) {
			dp[0][i] = arr[i] % 2 == 0 ? dp[0][i-1] + 1 : 0;
			max = Math.max(max, dp[0][i]);
		}
		
		for(int i=1; i<=K; i++) {
			for(int j=0; j<N; j++) {
				if( j == 0 ) {
					dp[i][j] = dp[i-1][j];
				} else {
					if( arr[j] % 2 == 1 ) {
						dp[i][j] = dp[i-1][j-1];
					} else {
						dp[i][j] = dp[i][j-1] + 1;
					}
				}
				max = Math.max(max, dp[i][j]);
			}
		}
		System.out.println(max);
	}
	
}
