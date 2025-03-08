import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		// 1. dp
//		int[] dp = new int[1000001];			// 최소 연산 횟수
//
//		if( K - N > 1 ) {
//			for(int i=N; i<=K; i++) {
//				if( i == N ) dp[i] = 0;			// 기저값 : N일때 최소연산 횟수 0
//				else {
//					// 1번 연산만 하여 최솟값 세팅
//					if( dp[i] == 0 ) dp[i] = dp[i-1] + 1;
//					else dp[i] = Math.min(dp[i], dp[i-1]+1);
//				}
//				
//				// 현재 수에서 K보다 작을 때까지 2번 연산만 진행하여 최소 연산 횟수 세팅
//				int idx = i;
//				while( true ) {
//					if( idx * 2 > K ) break;
//					if( dp[idx*2] == 0 ) dp[idx*2] = dp[idx] + 1; 
//					else dp[idx*2] = Math.min(dp[idx*2], dp[idx] + 1);
//					idx *= 2;
//				}
//			}
//			System.out.println(dp[K]);
//		}
		
		
		// 2. 그리디 : 2번 연산이 많을수록 최소횟수가 나오므로 2로 나눠지면 2번연산 수행, 나눠지지 않으면 1번연산 수행하며 연산횟수 찾기
		int cnt = 0;
		while( true ) {
			if( K == N ) break;
			if( K % 2 == 0 && K / 2 >= N) {
				K /= 2;
			} else {
				K--;
			}
			cnt++;
		}
		System.out.println(cnt);
	}

}
