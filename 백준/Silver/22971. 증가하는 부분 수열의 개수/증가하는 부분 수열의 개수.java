import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int MOD = 998244353;
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[N];
		int[] dp = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i] = 1;
		}
		
		for(int i=1; i<N; i++) {
			int sum = 0;
			for(int j=0; j<i; j++) {
				if( arr[i] > arr[j] ) {
					sum = (sum + dp[j]) % MOD;
				}
			}
			dp[i] = (dp[i] + sum) % MOD;
		}
		
		for(int n : dp) {
			sb.append(n+" ");
		}
		System.out.println(sb.toString());
	}

}
