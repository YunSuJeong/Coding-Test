import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[N];
		int max = 0;
		for(int i=0; i<N; i++) {
			if( i < 2 ) dp[i] = arr[i];
			else {
				max = Math.max(max, dp[i-2]);
				dp[i] = arr[i] + max;
			} 
		}
		
		int result = dp[0];
		for(int i=1; i<N; i++) {
			result = Math.max(result, dp[i]);
		}
		System.out.println(result);
	}

}
