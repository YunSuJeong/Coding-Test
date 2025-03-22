import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static int N, K;
	public static int[] L;
	public static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		dp = new int[N][2];
		L = new int[N-1];
		
		StringTokenizer Li = new StringTokenizer(br.readLine());
		for(int i=0; i<N-1; i++) {
			L[i] = Integer.parseInt(Li.nextToken());
		}
		
		dp[0][0] = 1;			// 점프 안하고 밟은 블럭의 최대 개수
		dp[0][1] = 1;			// 최대 1번 점프하고 밟은 블럭의 최대 개수
		
		int m1 = dp[0][0], m2 = dp[0][1];
		for(int i=0; i<N-1; i++) {
			if( L[i] <= K ) {
				// 거리가 보폭보다 작다면, 무조건 이전 최대 개수 + 1
				dp[i+1][0] += dp[i][0] + 1;		
				dp[i+1][1] += dp[i][1] + 1;
			} else {
				dp[i+1][0] = 1;						// 점프안했다면 개수 새로 새기
				dp[i+1][1] = dp[i][0] + 1;			// 점프했다면, 이전까지 점프안하고 밟은 최대 개수에 + 1
			}
			m1 = Math.max(m1, dp[i+1][0]);
			m2 = Math.max(m2, dp[i+1][1]);
		}
		
		System.out.println(m1 > m2 ? m1 : m2);
	}

}
