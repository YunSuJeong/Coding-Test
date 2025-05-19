import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			boolean[] arr = new boolean[10];
			int cnt = 0;
			
			while( N > 0 ) {
				int remain = N % 10;
				
				if( !arr[remain] ) {
					cnt++;
					arr[remain] = true;
				}
				
				N /= 10;
			}
			System.out.printf("#%d %d\n", tc, cnt);
		}
	}

}
