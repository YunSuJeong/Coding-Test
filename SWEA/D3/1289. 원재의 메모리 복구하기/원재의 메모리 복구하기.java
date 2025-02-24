
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			String memory = br.readLine();
			
			int cnt = 1;
			int idx = memory.indexOf("1");
			if( idx >= 0 ) {
				for(int i=idx; i<memory.length()-1; i++) {
					if( memory.charAt(i) != memory.charAt(i+1)) cnt++;
				}
			} else {
				cnt = 0;
			}
			System.out.printf("#%d %d\n", tc, cnt);
		}
	}

}
