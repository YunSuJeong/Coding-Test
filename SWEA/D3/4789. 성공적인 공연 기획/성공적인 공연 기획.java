import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			String str = br.readLine();
			
			int cnt = str.charAt(0) - '0'; 		// 현재 박수치고 있는 인원
			int min = 0;
			for(int i=1; i<str.length(); i++) {
				int p = str.charAt(i) - '0';
				if( p > 0 ) {
					if( cnt < i ) {
                        // 추가 필요인원 i-cnt
						min += i - cnt;
						cnt += i - cnt;
					}
					cnt += p;
				}
			}
			
			System.out.printf("#%d %d\n", tc, min);
		}
	}

}
