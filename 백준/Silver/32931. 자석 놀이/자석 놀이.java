import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static int N;
	public static long[][] arr, dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new long[2][N];
		dp = new long[2][N];
		
		for(int i=0; i<2; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dp[0][0] = arr[0][0] + Math.max(0, arr[1][0]);
		dp[1][0] = arr[0][0] + arr[1][0];
		
		for(int i=1; i<N; i++) {
			for(int j=0; j<2; j++) {
				if( j == 0 ) {
					dp[0][i] = Math.max(dp[1][i-1] + arr[1][i], Math.max(dp[0][i-1], dp[0][i-1] + arr[1][i])) + arr[0][i];
				} else {
					dp[1][i] = Math.max(dp[0][i-1] + arr[0][i], Math.max(dp[1][i-1], dp[1][i-1] + arr[0][i])) + arr[1][i];
				}
			}
		}
		
		System.out.println(dp[1][N-1]);
	}
	
}
