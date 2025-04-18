import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
			
		int N = Integer.parseInt(st.nextToken());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int[] dp = new int[N+1];
		Arrays.fill(dp, N+1);
		
		if( N == 0 ) {
			System.out.println(0);
		} else {
			dp[N] = 0;
			dp[N-1] = 1;
			for(int i=N; i>0; i--) {
				if( i - 1 >= 0 ) dp[i-1] = Math.min(dp[i-1], dp[i] + 1);
				if( i - a - 1 >= 0 ) dp[i-a-1] = Math.min(dp[i-a-1], dp[i] + 1);
				if( i - b - 1 >= 0 ) dp[i-b-1] = Math.min(dp[i-b-1], dp[i] + 1);
			}
			System.out.println(dp[0]);
		}
	}

}
