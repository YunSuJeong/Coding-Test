import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		// 알파벳 별 구멍개수 세팅
		int[] arr = new int[26];
		for(int i=0; i<26; i++) {
			int ascii = 65 + i;
			if( ascii == 'B' ) arr[i] = 2;
			else if( ascii == 'A' || ascii == 'D' || ascii == 'O' || ascii == 'P' || ascii == 'Q' || ascii == 'R' ) {
				arr[i] = 1;
			} else {
				arr[i] = 0;
			}
		}
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			String str1 = st.nextToken();
			String str2 = st.nextToken();
			
			boolean flag = true;
			if( str1.length() != str2.length() ) flag = false;
			
			if( flag ) {
				for(int i=0; i<str1.length(); i++) {
					if( arr[str1.charAt(i)-'A'] != arr[str2.charAt(i)-'A'] ) {
						flag = false;
						break;
					}
				}
			}
			
			System.out.printf("#%d %s\n", tc, flag ? "SAME" : "DIFF");
		}
	}

}
