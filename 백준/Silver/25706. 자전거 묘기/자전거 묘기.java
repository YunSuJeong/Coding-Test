import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 점프대 높이
		int[] H = new int[N];				
		for(int i=0; i<N; i++) {
			H[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[N];
		dp[N-1] = 1;
		for(int i=N-2; i>=0; i--) {
			if( H[i] == 0 ) {
				dp[i] = dp[i+1] + 1;
			} else {
				if( i+H[i]+1 >= N ) dp[i] = 1;
				else dp[i] = dp[i+H[i]+1] + 1;
			}
		}
		
		for(int n : dp) {
			sb.append(n+" ");
		}
		System.out.println(sb.toString());
	}

}
