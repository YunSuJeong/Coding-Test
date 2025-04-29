import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			char[] arr = br.readLine().toCharArray();
			
			int o = 0;				// 현재 소정이가 이긴 횟수
			for(char c : arr) {
				if( c == 'o' ) o++;
			}
			
			String result = "YES";
			if( o < 8 ) {
				int match = 15 - arr.length;		// 남은 팔씨름 횟수
				int min = 8 - o;					// 면제받기 위해 소정이가 앞으로 이겨야할 최소 횟수
				
				if( match < min ) result = "NO";
			} 
			System.out.printf("#%d %s\n", tc, result);
		}
	}

}
