import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String s1 = br.readLine();
		String s2 = br.readLine();
		
		int N = s1.length();
		int M = s2.length();
		
		int[][] dp = new int[N+1][M+1];
		
		for(int i=1; i<=N; i++) {
			char c1 = s1.charAt(i-1);
			for(int j=1; j<=M; j++) {
				char c2 = s2.charAt(j-1);
				if( c1 == c2 ) {
					dp[i][j] = dp[i-1][j-1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		
		int i = N, j = M;
		while( i > 0 && j > 0 ) {
			if( s1.charAt(i-1) == s2.charAt(j-1) ) {
				sb.append(s1.charAt(i-1));
				i--;
				j--;
			} else {
				if( dp[i-1][j] > dp[i][j-1] ) {
					i--;
				} else {
					j--;
				}
			}
		}
		
		System.out.println(dp[N][M]);
		if( dp[N][M] > 0 ) System.out.println(sb.reverse().toString());
	}

}
