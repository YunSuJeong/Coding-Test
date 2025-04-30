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
			
			int len = a;
			if( a == b && b == c && a == c ) len = a;
			else if( a == b && a != c ) len = c;
			else if( b == c && b != a ) len = a;
			else if( a == c && a != b ) len = b;
			
			System.out.printf("#%d %d\n", tc, len);
		}
	}

}
