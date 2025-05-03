import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	
	public static int a, b;
	public static String str;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			str = br.readLine();
			
			a = b = 1;			// 초기화
			
			findNode(0, a, b);
			
			int gcd = gcd(a, b);
			System.out.printf("#%d %d %d\n", tc, a/gcd, b/gcd);
		}
	}
	
	public static void findNode(int i, int x, int y) {
		if( i == str.length() ) {
			a = x;
			b = y;
			return;
		}
		if( str.charAt(i) == 'L' )
			findNode(i+1, x, x+y);
		else
			findNode(i+1, x+y, y);
	}

	public static int gcd(int a, int b) {
		if( b == 0 ) return a;
		else return gcd(b, a%b);
	}
}
