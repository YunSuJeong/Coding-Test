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
			
			boolean[] arr = new boolean[10];
			for(int i=0; i<len; i++) {
				int num = str.charAt(i) - '0';
				
				if( arr[num] ) arr[num] = false;
				else arr[num] = true;
			}
			
			int cnt = 0;
			for(int i=0; i<10; i++) {
				if( arr[i] ) cnt++; 
			}
			System.out.printf("#%d %d\n", tc, cnt);
		}
	}

}
