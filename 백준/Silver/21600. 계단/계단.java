import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[N];
		int[][] dp = new int[N+1][N];
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
		}
		
		int max = 0;
		for(int i=0; i<N; i++) max = Math.max(max, dp[N][i]);
		System.out.println(max);
	}

}
