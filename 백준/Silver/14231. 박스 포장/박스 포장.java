import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[N];
		int max = 1;
		for(int i=0; i<N; i++) {
			dp[i] = Math.max(dp[i], 1);			// 1로 초기화
			for(int j=i+1; j<N; j++) {
				if( arr[j] > arr[i] ) dp[j] = Math.max(dp[j], dp[i]+1);
				max = Math.max(max, dp[j]);
			}
		}
		System.out.println(max);
	}

}
