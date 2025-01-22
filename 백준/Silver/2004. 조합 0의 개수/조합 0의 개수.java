import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long N = Integer.parseInt(st.nextToken());
		long M = Integer.parseInt(st.nextToken());
			
		// 1. 조합 계산될 , 분자/분모 2,5개수 각각 구하여 빼서 구하기 : 시간초과
//		int cnt1 = 0, cnt2 = 0;
//		for(long i=M; i>=1; i--) {
//			long mole = i+(N-M);
//			long deno = i;
//			while( mole % 2 == 0 || mole % 5 == 0 ) {
//				if( mole % 2 == 0 ) {
//					mole /=2;
//					cnt1++;
//				}
//				if( mole % 5 == 0 ) {
//					mole /=5;
//					cnt2++;
//				}
//			}
//			while( deno % 2 == 0 || deno % 5 == 0 ) {
//				if( deno % 2 == 0 ) {
//					deno /=2;
//					cnt1--;
//				}
//				if( deno % 5 == 0 ) {
//					deno /=5;
//					cnt2--;
//				}
//			}
//		}
//		int cnt = Math.min(cnt1, cnt2);
		
		// 2. n! m! (n-m)! 각각 10의 개수 구하여 빼기
		// 2의 개수
		if( N == M || M == 0 ) System.out.println(0);
		else {
			long cntN2 = 0, cntM2 = 0, cntNM2 = 0;
			for(long i=2; i<=N; i*=2) {
				cntN2 += N/i;
			}
			for(long i=2; i<=M; i*=2) {
				cntM2 += M/i;
			}
			for(long i=2; i<=N-M; i*=2) {
				cntNM2 += (N-M)/i;
			}
			long cnt2 = cntN2 - cntM2 - cntNM2;
			
			// 5의 개수
			long cntN5 = 0, cntM5 = 0, cntNM5 = 0;
			for(long i=5; i<=N; i*=5) {
				cntN5 += N/i;
			}
			for(long i=5; i<=M; i*=5) {
				cntM5 += M/i;
			}
			for(long i=5; i<=N-M; i*=5) {
				cntNM5 += (N-M)/i;
			}
			long cnt5 = cntN5 - cntM5 - cntNM5;
			System.out.println(Math.min(cnt2, cnt5));
		}
	}
	

}
