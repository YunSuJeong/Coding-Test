import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] dp = new int[N][N];		// 누적합
		
		for(int i=0; i<N; i++) {
			StringTokenizer num = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				int n = Integer.parseInt(num.nextToken());
				
				if( j == 0 ) dp[i][j] = n;
				else dp[i][j] = dp[i][j-1] + n;
			}
		}
		
		for(int i=0; i<M; i++) {
			StringTokenizer range = new StringTokenizer(br.readLine());
			
			int x1 = Integer.parseInt(range.nextToken()) - 1;
			int y1 = Integer.parseInt(range.nextToken()) - 1;
			int x2 = Integer.parseInt(range.nextToken()) - 1;
			int y2 = Integer.parseInt(range.nextToken()) - 1;

			int sum = 0;
			for(int j=x1; j<=x2; j++) {
				if( y1 == 0 ) {
					sum += dp[j][y2];
				} else {
					sum += dp[j][y2] - dp[j][y1-1];
				}
			}
			sb.append(sum+"\n");
		}
		System.out.println(sb.toString());
	}

}
