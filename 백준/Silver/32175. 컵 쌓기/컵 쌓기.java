import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int MOD = 1000000007;
		
		StringTokenizer A = new StringTokenizer(br.readLine());
		
		int[] arr = new int[101];						// 높이 별 컵의 종류 수
		long[] dp = new long[100001];
		for(int i=0; i<N; i++) {
			int a = Integer.parseInt(A.nextToken());
			arr[a]++;
		}
		
		// 기저값 
		for(int i=1; i<=100; i++) {
			dp[i] = arr[i];
		}
		
		for(int i=1; i<=H; i++) {
			for(int j=1; j<=100; j++) {
				if( arr[j] > 0 && i - j > 0 ) dp[i] = (dp[i] + (dp[i-j] * arr[j]) % MOD) % MOD;
			}
		}
		System.out.println(dp[H]);
	}

}
