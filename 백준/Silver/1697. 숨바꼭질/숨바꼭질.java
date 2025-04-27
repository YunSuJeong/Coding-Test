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
		int K = Integer.parseInt(st.nextToken());
		
		long[] dp = new long[100001];
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		// 기저값 세팅
		for(int i=N; i>=0; i--) {
			dp[i] = N-i;
		}
		
		for(int i=1; i<=100000; i++) {
			dp[i] = Math.min(dp[i], dp[i-1]+1);
			if( i + 1 <= 100000 ) dp[i] = Math.min(dp[i], dp[i+1]+1);
			for(int j=i*2; j<=100000; j*=2) {
				dp[j] = Math.min(dp[j], dp[j/2] + 1);
			}
		}
		System.out.println(dp[K]);
	}

}
