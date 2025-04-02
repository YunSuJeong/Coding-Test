import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			String str = br.readLine();
			int N = Integer.parseInt(str);
			int len = str.length();
			int[] arr = new int[10];
			
			// 각 숫자 개수 
			for(int i=0; i<len; i++) {
				arr[str.charAt(i)-'0']++;
			}
			
			boolean flag = false;
			int multi = 2;
			String tmp;
			
			while( true ) {
				tmp = Integer.toString(N * multi);
				
				if( len < tmp.length() || flag ) break;
				
				int[] newNum = new int[10];
				for(int i=0; i<len; i++) {
					newNum[tmp.charAt(i)-'0']++;
				}
				
				for(int i=0; i<10; i++) {
					if( arr[i] == newNum[i] ) {
						flag = true;
					} else {
						flag = false;
						break;
					}
				}
				
				multi++;
			}
			
			System.out.printf("#%d %s\n", tc, flag ? "possible" : "impossible");
		}
	}
}
