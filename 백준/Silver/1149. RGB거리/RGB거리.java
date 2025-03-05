import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[N][3];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int R = Integer.parseInt(st.nextToken());
			int G = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			arr[i][0] = R;
			arr[i][1] = G;
			arr[i][2] = B;
		}
		
		// 현재 i층을 R, G, B로 칠할 때, 최소 비용
		int[][] dp = new int[N][3];
		dp[0][0] = arr[0][0];				
		dp[0][1] = arr[0][1];		
		dp[0][2] = arr[0][2];	
		
		for(int i=1; i<N; i++) {
			dp[i][0] = arr[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);		// i층을 R로 칠할 때 최소비용 = i층의 R 비용 + (이전 층의 G/B 비용 중 최솟값)
			dp[i][1] = arr[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
			dp[i][2] = arr[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
		}
		
		int min = dp[N-1][0];
		for(int i=1; i<3; i++) {
			min = Math.min(min, dp[N-1][i]);
		}
		System.out.println(min);
	}

}
