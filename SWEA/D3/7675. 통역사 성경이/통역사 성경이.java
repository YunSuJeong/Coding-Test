import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			int cnt = 0; 		// 현재까지 나온 문장 수
			int word = 0;
			while( cnt < N ) {
				String sentence = br.readLine();
				
				for(String str : sentence.split(" ")) {
					// 첫 글자가 대문자일 때만 
					int len = str.length();
					if( str.charAt(0) >= 65 && str.charAt(0) <= 91 ) {
						
						boolean flag = true;
						for(int i=1; i<len; i++) {
							if( !(str.charAt(i) >= 97 && str.charAt(i) <= 123) && str.charAt(i) != '.' && str.charAt(i) != '!' && str.charAt(i) != '?' ) {
								flag = false;
								break;
							}
						}						
						if( flag ) word++;
						
					}
					if( str.charAt(len-1) == '.' || str.charAt(len-1) == '!' || str.charAt(len-1) == '?' ) {
						cnt++;
						sb.append(word+" ");
						word = 0;
					}
				}
			}
			System.out.printf("#%d %s\n", tc, sb.toString());
			sb.setLength(0);
		}
	}

}
