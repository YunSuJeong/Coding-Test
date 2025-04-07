import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str = "";
		
		while( (str=br.readLine()) != null ) {
			
			int N = Integer.parseInt(str);
			
			if( N == 0 ) break;
			
			int[] arr = new int[N];
			int[] dp = new int[N];
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(br.readLine());
				dp[i] = arr[i];
			}
			
			int max = dp[0];
			for(int i=1; i<N; i++) {
				dp[i] = Math.max(dp[i], dp[i-1]+arr[i]);
				max = Math.max(max, dp[i]);
			}
			
			sb.append(max+"\n");
		}
		System.out.println(sb.toString());
	}

}
