import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[]dp = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			if( i < 4 ) {
				dp[i] = (int) Math.pow(2, i-1);
			} else {
				dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
				if( i % 2 == 1 ) dp[i] += dp[i-4];
			}
		}
		
		System.out.println(dp[N]);
	}

}
