import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int dp[] = new int[N+1];
		for(int i=0; i<=N; i++) {
			if( i <= 1 ) dp[i] = 0;
			else if( i <= 3 ) dp[i] = 1;
			else {
				int min = 1000000;
				if( i % 2 == 0 && i % 3 == 0 ) {
					min = Math.min(Math.min(dp[i-1], dp[i/2]), dp[i/3]) +1;
				} else if( i % 2 == 0 && i % 3 != 0 ) {
					min = Math.min(dp[i-1], dp[i/2]) +1;
				} else if( i % 2 != 0 && i % 3 ==0 ) {
					min = Math.min(dp[i-1], dp[i/3]) +1;
				} else {
					min = dp[i-1] + 1;
				}
				dp[i] = min;
			}
		}
		System.out.println(dp[N]);
	}

}
