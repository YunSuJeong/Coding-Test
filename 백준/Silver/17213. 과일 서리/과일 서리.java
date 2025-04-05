import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		int[][] dp = new int[M+1][N+1];
		dp[N][0] = 1;
		
		for(int i=N+1; i<=M; i++) {
			int sum = 0;
			for(int j=N; j>=1; j--) {
				if( i == N+1 ) dp[i][j] = 1;
				else {
					sum += dp[i-1][j];
					dp[i][j] = sum;
				}
			}
		}
		
		int cnt = 0;
		for(int n : dp[M]) {
			cnt += n;
		}
		System.out.println(cnt);
	}

}
