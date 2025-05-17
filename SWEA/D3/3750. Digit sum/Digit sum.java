import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			long n = Long.parseLong(br.readLine());
			
			//  n이 한 자리수가 될 때까지 반복
			while( n >= 10 ) {
				long funN = 0;
				while( n > 0 ) {
					funN += n % 10;
					n /= 10;
				}
				// n에 f(n)을 대입
				n = funN;
			}
			System.out.printf("#%d %d\n", tc, n);
		}
	}

}
