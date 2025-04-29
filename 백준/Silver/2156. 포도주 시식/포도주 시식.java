import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N+1];
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int max = 0;
		int[] dp = new int[N+1];
		for(int i=1; i<=N; i++) {
			if( i <= 2 ) {
				dp[i] = dp[i-1] + arr[i];
			} else {
				// (현재 연속으로 시식, 현재 것만 시식) 중 최대 시식
				dp[i] = Math.max(dp[i-1], Math.max(dp[i-3] + arr[i-1] + arr[i], dp[i-2] + arr[i]));
			}
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}

}
