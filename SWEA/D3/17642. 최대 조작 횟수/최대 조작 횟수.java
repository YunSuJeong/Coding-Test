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
			
			long A = Long.parseLong(st.nextToken());
			long B = Long.parseLong(st.nextToken());
			
			if( A > B || B - A == 1 ) {
				System.out.printf("#%d %d\n", tc, -1);
			} else if( A == B ) {
				System.out.printf("#%d %d\n", tc, 0);
			} else {
				System.out.printf("#%d %d\n", tc, (B-A)/2);
			}
		}
	}

}
