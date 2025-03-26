import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] dp = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			dp[i] = arr[i];
		}
		
		int max = 0;
		for(int i=0; i<N-1; i++) {
			for(int j=i; j<N; j++) {
				if( arr[j] > arr[i] ) {
					dp[j] = Math.max(dp[j], dp[i] + arr[j]);
				}
				max = Math.max(max, dp[j]);
			}
		}
		
		System.out.println(max);
	}

}
