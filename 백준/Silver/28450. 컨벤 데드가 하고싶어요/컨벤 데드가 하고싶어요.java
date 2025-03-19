import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static int N, M, H;
	public static int[][] arr;
	public static long[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		// 지도 세팅
		arr = new int[N][M];
		dp = new long[N][M];
		for(int i=0; i<N; i++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(str.nextToken());
			}
		}
		
		H = Integer.parseInt(br.readLine());
		
		dp[0][0] = arr[0][0];
		for(int i=1; i<N; i++) {
			dp[i][0] = dp[i-1][0] + arr[i][0];
		}
		for(int i=1; i<M; i++) {
			dp[0][i] = dp[0][i-1] + arr[0][i];
		}
		
		for(int i=1; i<N; i++) {
			for(int j=1; j<M; j++) {
				long right =  dp[i][j-1] + arr[i][j];
				long down = dp[i-1][j] + arr[i][j];
				dp[i][j] = Math.min(right, down);
			}
		}
		if( dp[N-1][M-1] > H ) {
			System.out.println("NO");
		} else {
			System.out.println("YES");
			System.out.println(dp[N-1][M-1]);
		}
	}

}
