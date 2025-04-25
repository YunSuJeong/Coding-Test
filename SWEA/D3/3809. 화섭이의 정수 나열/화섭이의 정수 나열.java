import java.io.IOException;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			
			int n = N/20;
			if( N % 20 > 0 ) n++;
			for(int i=0; i<N; i++) {
				sb.append(sc.next());
			}
			String strN = sb.toString();
			
			long num = 0;
			while( true ) {
				if( strN.indexOf(Long.toString(num)) < 0 ) break;
				
				num++;
			}
			
			System.out.printf("#%d %d\n", tc, num);
			
			sb.setLength(0);
		}
	}

}
