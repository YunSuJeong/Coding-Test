import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			long N = Long.parseLong(br.readLine());
			
			// 약수를 이용하여 최소 이동 횟수 구하기
			long min = N-1;
			for(long i=2; i*i<=N; i++) {
				long remain = N % i;
				if( remain == 0 ) {
					long num = i - 1 + (N/i - 1);
					min = Math.min(min, num);
				}
			}			
			System.out.printf("#%d %d\n", tc, min);
		}
	}

}
