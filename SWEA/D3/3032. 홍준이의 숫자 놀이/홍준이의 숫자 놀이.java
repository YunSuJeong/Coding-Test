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
			
			int[] solve = extGcd(A, B);
			
			if( solve[2] != 1 ) 
				System.out.printf("#%d %d\n", tc, -1);
			else 
				System.out.printf("#%d %d %d\n", tc, solve[0], solve[1]);
 		}
	}
	
	public static int[] extGcd (int a, int b) {
		if( b == 0 ) return new int[] {1, 0, a};
		
		int[] tmp = extGcd(b, a%b);
		int x = tmp[1];
		int y = tmp[0] - (a/b) * tmp[1];
		return new int[] {x, y, tmp[2]};
	}

}
