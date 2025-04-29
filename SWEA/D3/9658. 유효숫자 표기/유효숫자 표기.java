import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			String str = br.readLine();
			
			int pow = str.length() - 1;
			int num = Integer.parseInt(str.substring(0, 3));
			
			if( num % 10 >= 5 ) {
				num = num / 10 + 1;
			} else {
				num /= 10;
			}
			
			if( num >= 100 ) {
				pow++;
				num /= 10;
			}
			System.out.printf("#%d %d.%d*10^%d\n", tc, num/10, num%10, pow);
		}
	}

}
