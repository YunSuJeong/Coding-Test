import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int c = Integer.parseInt(br.readLine());
		for(int tc=0; tc<c; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			int l1 = Integer.parseInt(st.nextToken());
			int l2 = Integer.parseInt(st.nextToken());
			int s1 = Integer.parseInt(st.nextToken());
			int s2 = Integer.parseInt(st.nextToken());
			
			int[][] striker1 = new int[2][n-1];
			int[][] striker2 = new int[2][n-1];
			
			for(int i=0; i<2; i++) {
				StringTokenizer S1 = new StringTokenizer(br.readLine());
				for(int j=0; j<n-1; j++) {
					striker1[i][j] = Integer.parseInt(S1.nextToken());
				}
			}
			for(int i=0; i<2; i++) {
				StringTokenizer S2 = new StringTokenizer(br.readLine());
				for(int j=0; j<n-1; j++) {
					striker2[i][j] = Integer.parseInt(S2.nextToken());
				}
			}
			
			int[][] dp = new int[2][n+1];
			dp[0][0] = l1;
			dp[1][0] = l2;
			for(int i=1; i<=n; i++) {
				if( i == n ) {
					dp[0][i] = dp[0][i-1] + s1;
					dp[1][i] = dp[1][i-1] + s2;
				} else {
					dp[0][i] = Math.min(dp[0][i-1] + striker1[1][i-1], dp[1][i-1] + striker2[0][i-1]);
					dp[1][i] = Math.min(dp[1][i-1] + striker2[1][i-1], dp[0][i-1] + striker1[0][i-1]);
				}
			}
			System.out.println(Math.min(dp[0][n], dp[1][n]));
		}
	}

}
