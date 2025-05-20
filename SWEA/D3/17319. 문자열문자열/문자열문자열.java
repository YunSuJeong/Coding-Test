import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			String str = br.readLine();
			
			boolean flag = true;
			if( N == 1 || N % 2 == 1 ) {
				flag = false;
			} else {
				for(int i=0; i<N/2; i++) {
					if( str.charAt(i) != str.charAt(N/2+i) ) {
						flag = false;
						break;
					}
				}
			}
			System.out.printf("#%d %s\n", tc, flag ? "Yes" : "No");
		}
	}

}
