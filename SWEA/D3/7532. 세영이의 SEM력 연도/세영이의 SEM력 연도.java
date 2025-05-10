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
			
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int year=1, s = 1, e = 1, m = 1;
			while( true ) {
				if( s == S && e == E && m == M ) break;

				s++;
				e++;
				m++;
				year++;
				
				if( m > 29 ) m = 1;
				if( e > 24 ) e = 1;
				if( s > 365 ) s = 1;
				
			}
			System.out.printf("#%d %d\n", tc, year);
		}
	}

}
