import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			String str = br.readLine();
			
			List<Integer> arr = new ArrayList<Integer>();
			
			int i = str.length()-1, n = 1, a = 0;
			while( true ) {
				char c = str.charAt(i);
				
				if( c == 'h') {
					if( i == str.length()-1 ) a = 0;
					else arr.add(-1);
					i -= 5;
				} else {
					if( i == str.length()-1 ) a = 90;
					else arr.add(1);
					i -= 4;
				}
				if( i < 0 ) break;
				n *= 2;
			}
			
			if( arr.size() == 0 ) {
				System.out.printf("#%d %d\n", tc, a);
			} else {
				int sum = a == 0 ? a : a * n, mod = n;
				for(int j=0; j<arr.size(); j++) {
					sum += 90 * (n/2) * arr.get(j);
					n /= 2;
				}
				if( sum % mod == 0 ) {
					System.out.printf("#%d %d\n", tc, sum/mod);
				} else {
					System.out.printf("#%d %d/%d\n", tc, sum/2, mod/2);
				}
			}
			
		}
 	}

}
