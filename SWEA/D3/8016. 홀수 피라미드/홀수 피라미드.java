import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			// 제일 왼쪽 = 1 + 전 층까지 홀수 개수 * 2
			// 제일 오른쪽 = 제일 왼쪽 + (전 층의 홀수 개수 + 1) * 2
			long left = 1, right = 1;

			if( N > 1 ) {
				long cnt = 1;				// 전층의 개수
				long sum = 1;				// 전층까지 모든 홀수 개수
				for(int i=1; i<N-1; i++) {
					cnt += 2;
					sum += cnt;
				}
				left = 1 + sum * 2;
				right = left + (cnt+1) * 2;
			}
			System.out.printf("#%d %d %d\n", tc, left, right);
		}
	}

}
