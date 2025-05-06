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
		int K = Integer.parseInt(st.nextToken());
		
		int kx = 0, ky = 0;
		int[][] dp = new int[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if( i == 0 || j == 0 ) dp[i][j] = 1;
				if( kx == 0 && ky == 0 && i * M + (j + 1) == K ) {
					kx = i;
					ky = j;
				}
			}
		}
		
		if( K == 0 ) {
			for(int i=1; i<N; i++) {
				for(int j=1; j<M; j++) {
					dp[i][j] = dp[i-1][j] + dp[i][j-1];
				}
			}
			System.out.println(dp[N-1][M-1]);
		} else {
			for(int i=1; i<N; i++) {
				for(int j=1; j<M; j++) {
					if( (i == kx && j > ky) || (i > kx && j == ky) ) {
						dp[i][j] = 1;
					} else {
						dp[i][j] = dp[i-1][j] + dp[i][j-1];
					}
				}
			}
			System.out.println(dp[kx][ky]*dp[N-1][M-1]);
		}
	}

}
