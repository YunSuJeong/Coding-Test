import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			String S = br.readLine();
			String E = br.readLine();
			
			StringBuilder sb = new StringBuilder(E);
			String result = "No";
			// 문자열 E의 길이가 더 길거나 같을 때만 연산 시행
			for(int i=0; i<E.length()-S.length(); i++) {
				int idx = sb.toString().length() - 1;
				if( sb.toString().charAt(idx) == 'Y' ) {
					// E의 맨 뒤 문자이 Y일 때
					sb.deleteCharAt(idx);		// 맨 뒤 Y 삭제하고 
					sb.reverse();							// 뒤집기
				} else {
					// X일 때
					sb.deleteCharAt(idx);		// 맨 뒤 X 삭제
				}
			}
			if( S.equals(sb.toString()) ) result = "Yes";
			
			System.out.printf("#%d %s\n", tc, result);
		}
	}

}
