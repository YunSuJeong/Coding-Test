import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] dp = new int[1000001];			// 최소 연산 횟수

		if( K - N > 1 ) {
			// 1씩 늘어나는 연산
			for(int i=N; i<=K; i++) {
				if( i == N ) dp[i] = 0;
				else {
					if( dp[i] == 0 ) dp[i] = dp[i-1] + 1;
					else dp[i] = Math.min(dp[i], dp[i-1]+1);
				}
				
				int idx = i;
				// 2번 연산만 한 경우
				while( true ) {
					if( idx * 2 > K ) break;
					if( dp[idx*2] == 0 ) dp[idx*2] = dp[idx] + 1; 
					else dp[idx*2] = Math.min(dp[idx*2], dp[idx] + 1);
					idx *= 2;
				}
			}
			System.out.println(dp[K]);
		}
		
	}

}
