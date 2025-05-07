import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[N];
		
		// 1. 2차원으로 설계하면 메모리 및 시간초과 O(n^2)
		/*int[][] dp = new int[N+1][N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[1][i] = 1;
		}
		
		for(int i=2; i<=N; i++) {
			for(int j=1; j<N; j++) {
				if( arr[j] >= i ) {
					dp[i][j] = dp[i-1][j-1] + 1;
				} else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}*/

		// 2. 1차원으로 설계하여 풀어야함
		int[] dp = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[0] = 1;
        // 현재 히스토그램 높이 >= 이번 계단 높이 : 바로 이전 히스토그램까지의 계단 최대 길이 + 1
        // 현재 히스토그램 높이 < 이번 계단 높이 : 이번 히스토그램 높이
		for(int i=1; i<N; i++) {
			dp[i] = Math.min(dp[i-1] + 1, arr[i]);
		}

		
		
		int max = 0;
		for(int i=0; i<N; i++) max = Math.max(max, dp[i]);
		System.out.println(max);
	}

}
