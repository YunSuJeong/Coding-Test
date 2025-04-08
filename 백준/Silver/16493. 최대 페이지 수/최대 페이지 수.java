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
		
		int[][] arr = new int[M+1][2];
		
		// i번째 챕터까지 고려했을 때(읽을지/말지), N일동안 읽을 수 있는 최대 페이지 수
		int[][] dp = new int[M+1][N+1];
		
		for(int i=1; i<=M; i++) {
			StringTokenizer chap = new StringTokenizer(br.readLine());
			
			int D = Integer.parseInt(chap.nextToken());
			int P = Integer.parseInt(chap.nextToken());
			
			arr[i][0] = D;
			arr[i][1] = P;
		}

		for(int i=1; i<=M; i++) {
			for(int j=1; j<=N; j++) {
				if( arr[i][0] > j ) {
					dp[i][j] = dp[i-1][j];
				} else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-arr[i][0]] + arr[i][1]);
				}
			}
		}
		
		System.out.println(dp[M][N]);
	}

}
