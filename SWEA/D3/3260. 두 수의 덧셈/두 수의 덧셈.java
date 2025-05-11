import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			String A = st.nextToken();
			String B = st.nextToken();
			
			int i1 = A.length()-1, i2 = B.length()-1;
			int a, b, sum = 0;
			while( true ) {
				if( i1 < 0 && i2 < 0 ) break;
				
				if( i1 >= 0 ) a = A.charAt(i1) - '0';
				else a = 0;
				
				if( i2 >= 0 ) b = B.charAt(i2) - '0';
				else b = 0;
				
				sum += a + b;
				sb.append(sum%10);
				sum /= 10;
				
				i1--;
				i2--;
			}
			if( sum > 0 ) sb.append(sum);
			System.out.printf("#%d %s\n", tc, sb.reverse().toString());
			sb.setLength(0);
		}
	}

}
