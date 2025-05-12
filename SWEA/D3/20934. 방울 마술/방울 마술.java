import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			String cups = st.nextToken();
			int K = Integer.parseInt(st.nextToken());
			
			int idx = 0;
			for(int i=0; i<3; i++) {
				if( cups.charAt(i) == 'o' ) idx = i;
			}
			
			// K == 0일 땐, 현재 위치 그대로 출력
			int bell = 0;
			if( K == 0 ) {
				bell = idx;
			} else if( K == 1 ) {
				if( idx == 1 ) {
					bell = 0;
				} else {
					bell = 1;
				}
			} else {
				if( idx == 1 ) {
					if( K % 2 == 0 ) bell = 1;
					else bell = 0;
				} else {
					if( K % 2 == 0 ) bell = 0;
					else bell = 1;
				}
			}
			System.out.printf("#%d %d\n", tc, bell);
		}
	}

}
