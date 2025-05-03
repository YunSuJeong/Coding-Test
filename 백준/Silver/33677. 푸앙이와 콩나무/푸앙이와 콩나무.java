import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] dp = new int[1000001][2];
		
		for(int[] d : dp) {
			Arrays.fill(d, Integer.MAX_VALUE);
		}
		
		dp[0][0] = 0;
		dp[0][1] = 0;
		for(int i=0; i<=1000000; i++) {
			if( i + 1 <= N && dp[i+1][0] >= dp[i][0] + 1 ) {
				dp[i+1][0] = dp[i][0] + 1;
				dp[i+1][1] = Math.min(dp[i+1][1], dp[i][1] + 1);
			}
			if( i * 3 <= N && dp[i*3][0] >= dp[i][0] + 1 ) {
				dp[i*3][0] = dp[i][0] + 1;
				dp[i*3][1] = Math.min(dp[i*3][1], dp[i][1] + 3);
			} 
			if( i <= 1000 && dp[i*i][0] >= dp[i][0] + 1 ) {
				dp[i*i][0] = dp[i][0] + 1;
				dp[i*i][1] = Math.min(dp[i*i][1], dp[i][1] + 5);
			} 
		}
		System.out.println(dp[N][0]+" "+dp[N][1]);
	}
}
