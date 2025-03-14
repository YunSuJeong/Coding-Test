import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int[] arr = new int[N];
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int[] dp = new int[N]; 			// 현재 숫자까지 최장 부분 증가 수열 길이
			for(int i=0; i<N; i++) dp[i] = 1;
			for(int i=0; i<N; i++) {
				for(int j=i+1; j<N; j++) {
					if( arr[j] >= arr[i] ) {
						dp[j] = Math.max(dp[i]+1, dp[j]);
					}
				}
			}
			
			int max = dp[0];
			for(int i=1; i<N; i++) {
				max = Math.max(max, dp[i]);
			}
			
			System.out.printf("#%d %d\n", tc, max);
		}
	}

}
