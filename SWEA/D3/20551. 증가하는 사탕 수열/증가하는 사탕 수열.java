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
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			if( A < 1 || B < 2 || C < 3 ) {
				System.out.printf("#%d %d\n", tc, -1);
			} else {
				int min = 0;
				if( B >= C ) {
					min = B - (C-1);
					B = C - 1;
				}
				if( A >= B ) {
					min += A - (B-1);
					A = B - 1;
				}
				System.out.printf("#%d %d\n", tc, min);
			}
		}
	}

}
