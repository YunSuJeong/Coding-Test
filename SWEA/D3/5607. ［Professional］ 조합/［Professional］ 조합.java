import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static long MOD = 1234567891;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 2-1) N! mod P 구해놓기
		long[] factorial = new long[1000001];
		factorial[0] = 1;
		for(int i=1; i<=1000000; i++) {
			factorial[i] = factorial[i-1] * i % MOD;
		}
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			
			// 1. dp는 n의 범위때문에 메모리 초과남 
//			long[][] comb = new long[N+1][N+1];
//			for(int i=1; i<=N; i++) {
//				for(int j=0; j<=N; j++) {
//					if( j == 0 || j == i ) comb[i][j] = 1;
//					else comb[i][j] = (comb[i-1][j-1] + comb[i-1][j]) % 1234567891;
//				}
//			}
//			System.out.printf("#%d %d\n", tc, comb[N][R]);
			
			// 2. 페르마의 소정리 이용
			// 2-2) R!의 역원 mod P
			long result1 = power(factorial[R], MOD-2);
			// 2-3) (N-R)!의 역원 mod P
			long result2 = power(factorial[N-R], MOD-2);

			if( R == 0 || R == N ) System.out.printf("#%d %d\n", tc, 1);
			else System.out.printf("#%d %d\n", tc, (factorial[N]*result1%MOD*result2%MOD)%MOD);
		}
	}
	
	// 빠른 거듭제곱 연산
	public static long power(long a, long b) {
		long result = 1;
		
		// b는 지수
		while( b > 0 ) {
			if( b % 2 == 1 ) {
				result = (result * a) % MOD;
			} 
			a = (a * a) % MOD;
			b /= 2;
		}
		
		return result;
	}
	
}
