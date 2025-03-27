import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			int cnt = 1;
			if( N > 2 ) {
				int left = 1, right = 2, sum = left + right;
				while( left < right ) {
					if( right == N ) break;
					
					if( sum < N ) {
						right++;
						sum += right;
					} else if( sum > N ) {
						sum -= left;
						left++;
					}
					
					if( sum == N ) {
						cnt++;
						left++;
						right = left + 1;
						sum = left + right;
					}
				}
			}
			
			System.out.printf("#%d %d\n", tc, cnt);
		}
	}

}
