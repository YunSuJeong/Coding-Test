import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			long K = Long.parseLong(br.readLine()) - 1;
			
			int result = 0;
			while( K >= 0 ) {
                // 홀수면 짝수로 만들기
				if( K % 2 == 1 ) {
					K = (K-1) / 2;
				}
               
				if( K % 4 == 0 ) {
                     // 4의 배수면 0
					result = 0;
					break;
				} else if( K % 2 == 0 ) {
                    // 4의 배수가 아닌 짝수면 1
					result = 1;
					break;
				}
			}
			System.out.printf("#%d %s\n", tc, result);
		}
	}

}
