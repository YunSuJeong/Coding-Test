import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[][] dp = new int[N][2];
		dp[0][0] = 1;					// 현재 항까지 증가된 수열의 길이
		dp[0][1] = 1;					// 현재 항까지 감소된 수열의 길이
		int max = 1;
		for(int i=1; i<N; i++) {
			if( arr[i] >= arr[i-1] ) dp[i][0] = dp[i-1][0] + 1;
			else dp[i][0] = 1;
			
			if( arr[i] <= arr[i-1] ) dp[i][1] = dp[i-1][1] + 1;
			else dp[i][1] = 1;
			
			max = Math.max(max, Math.max(dp[i][0], dp[i][1]));
		}
		
		System.out.println(max);
	}

}
