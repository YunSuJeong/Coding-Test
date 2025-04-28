import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static int N, M, min = Integer.MAX_VALUE;
	public static int[][] arr;
//	public static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringTokenizer m = new StringTokenizer(br.readLine());
		StringTokenizer c = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][2];
		
		for(int i=0; i<N; i++) {
			arr[i][0] = Integer.parseInt(m.nextToken());
			arr[i][1] = Integer.parseInt(c.nextToken());
		}
		
		/*p = new int[10000001];
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		dp(0, arr[0][0], arr[0][1]);
		dp(0, 0, 0);*/
		
		// 2) 비용기준으로 dp테이블 설계
		int[] dp = new int[10001];			// N번째 앱까지 고려했을 때, 비용 c로 확보할 수 있는 최대 메모리
		for(int i=0; i<N; i++) {
			for(int j=10000; j>=arr[i][1]; j--) {
				dp[j] = Math.max(dp[j], dp[j-arr[i][1]] + arr[i][0]);
			}
		}
		for(int i=0; i<=10000; i++) {
			if( dp[i] >= M ) {
				min = i;
				break;
			}
		}

		System.out.println(min);
	}

	// 1) 메모리 기준으로 dp테이블 설계 -> 시간 복잡도 : 2의 N승이라 안됨
	// 재귀 말고 dp테이블을 2차원 테이블로 설계하면 문제 메모리 제한에 걸림
	/*public static void dp(int i, int n, int sum) {
		dp[n] = Math.min(dp[n], sum);
		
		if( n >= M ) min = Math.min(min, dp[n]);
		if( i == N - 1 ) return; 
		
		dp(i+1, n+arr[i+1][0], sum+arr[i+1][1]);
		dp(i+1, n, sum);
	}*/
}
