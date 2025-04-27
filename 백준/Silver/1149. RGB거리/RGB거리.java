import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][3];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int r = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr[i][0] = r;
			arr[i][1] = g;
			arr[i][2] = b;
		}
		
		int[][] dp = new int[N][3];
		for(int i=0; i<N; i++) {
			if( i == 0 ) {
				dp[i][0] = arr[i][0];
				dp[i][1] = arr[i][1];
				dp[i][2] = arr[i][2];
			} else {
				dp[i][0] = arr[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
				dp[i][1] = arr[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
				dp[i][2] = arr[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
			}
		}
		System.out.println(Math.min(dp[N-1][0], Math.min(dp[N-1][1], dp[N-1][2])));
	}

}
