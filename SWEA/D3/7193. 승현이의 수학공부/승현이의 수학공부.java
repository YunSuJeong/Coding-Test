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
			
			int N = Integer.parseInt(st.nextToken());
			String X = st.nextToken();
//			BigDecimal X = new BigDecimal(st.nextToken());
			
			int result = 0, pow = 1, remain = 1;
			
			for(int i=X.length()-1; i>=0; i--) {
				remain = X.charAt(i) - '0';
				result += ((pow * remain) % (N-1));
				pow = (pow * N) % (N-1);
				
			}
			
//			while( !X.equals(BigDecimal.ZERO) ) {
//				remain = X.remainder(BigDecimal.TEN).intValue();
//				X = X.divide(BigDecimal.TEN, BigDecimal.ROUND_DOWN);
//				
//				result += ((pow * remain) % (N-1));
//				pow = (pow * N) % (N-1);
//				System.out.println(remain+" "+pow+" "+result+" "+X);
//			}
			
			System.out.printf("#%d %d\n", tc, result%(N-1));
		}
	}

}
