import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			String str = br.readLine();
			
			int len = str.length();
			boolean flag = true;
			if( str.indexOf("*") >= 0 ) {
				int idx = str.indexOf("*");
				if( idx != 0 && idx != len - 1 ) {
					for(int i=0; i<len/2; i++) {
						if( str.charAt(i) == '*' || str.charAt(len-i-1) == '*' ) break;
						if( str.charAt(i) != str.charAt(len-i-1) ) {
							flag = false;
							break;
						}
					}
				}
			} else {
				for(int i=0; i<len/2; i++) {
					if( str.charAt(i) != str.charAt(len-i-1) ) {
						flag = false;
						break;
					}
				}
			}
			System.out.printf("#%d %s\n", tc, flag ? "Exist" : "Not exist");
		}
	}

}
