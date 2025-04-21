import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N][M];
		for(int i=0; i<N; i++) {
			StringTokenizer candy = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(candy.nextToken());
			}
		}
		
		int[][] dp = new int[N][M];
		// 기저값 세팅
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if( i == 0 && j == 0 ) {
					dp[i][j] = arr[i][j];
				} else if( i == 0 ) {
					dp[i][j] = arr[i][j] + dp[i][j-1];
				} else if( j == 0 ) {
					dp[i][j] = arr[i][j] + dp[i-1][j];
				} else {
					dp[i][j] = arr[i][j] + Math.max(dp[i-1][j-1], Math.max(dp[i-1][j], dp[i][j-1]));
				}
			}
		}
		
		System.out.println(dp[N-1][M-1]);
	}

}
