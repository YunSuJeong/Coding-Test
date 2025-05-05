import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			boolean[] alpha = new boolean[26];
			for(int i=0; i<N; i++) {
				char c = br.readLine().charAt(0);
				alpha[c-65] = true;					// 등장한 알파벳 체크
			}
			
			// A부터 사용가능한 제목 카운팅
			int cnt = 0;
			for(int i=0; i<26; i++) {
				if( !alpha[i] ) break;
				
				cnt++;
			}
			System.out.printf("#%d %d\n", tc, cnt);
		}
	}

}
