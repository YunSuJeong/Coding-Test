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
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			double diff = Math.abs(a-c) / 2.0;
			
			double x = 0;
			if( a < c ) {
				x = b - (a + diff);
			} else {
				x = b - (c + diff);
			}
			System.out.printf("#%d %.1f\n", tc, Math.abs(x));
		}
	}

}
