import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int len = arr[N-1] * K + 1;
		int[] dp = new int[len];
		
		Arrays.fill(dp, K+1);
		dp[0] = 0;
		for(int i=1; i<len; i++) {
			for(int j=N-1; j>=0; j--) {
				if( i >= arr[j] ) {
					dp[i] = Math.min(dp[i], dp[i-arr[j]] + 1);
				}
			}
		}
		
		int num = 0;
		for(int i=1; i<len; i++) {
			if( dp[i] > K ) {
				num = i;
				break;
			}
		}
		System.out.printf("%s win at %d", num % 2 == 0 ? "holsoon" : "jjaksoon", num);
	}

}
