import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringTokenizer stA = new StringTokenizer(br.readLine());
		StringTokenizer stB = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] A = new int[N];
		int[] B = new int[N];
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(stA.nextToken());
			B[i] = Integer.parseInt(stB.nextToken());
		}
		
		long[][] dp = new long[N][2];
		dp[0][0] = A[0];
		dp[0][1] = B[0];
		
		for(int i=1; i<N; i++) {
			dp[i][0] = Math.min(dp[i-1][0] + A[i], dp[i-1][1] + A[i] + K);
			dp[i][1] = Math.min(dp[i-1][1] + B[i], dp[i-1][0] + B[i] + K);
		}
		System.out.println(Math.min(dp[N-1][0], dp[N-1][1]));
	}

}
