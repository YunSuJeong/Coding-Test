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
			
			long[] dp = new long[N];
			
			int max = N-1;
			for(int i=N-2; i>=0; i--) {
				if( arr[i] > arr[max] ) {
					dp[i] = dp[i+1];
					max = i;
				} else {
					dp[i] = dp[i+1] + arr[max] - arr[i];
				}
			}
			System.out.printf("#%d %d\n", tc, dp[0]);
		}
	}

}
