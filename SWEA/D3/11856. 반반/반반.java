import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			String str = br.readLine();
			
			int[] arr = new int[26];
			for(int i=0; i<4; i++) {
				arr[str.charAt(i)-'A']++;
			}

			int alpha = 0, cnt = 0;
			for(int i=0; i<26; i++) {
				if( arr[i] > 0 ) alpha++;
				if( arr[i] == 2 ) cnt++;
			}
			System.out.printf("#%d %s\n", tc, alpha == 2 && cnt == 2 ? "Yes" : "No");
		}
	}

}
