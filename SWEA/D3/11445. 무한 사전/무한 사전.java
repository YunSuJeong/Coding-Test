import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			String P = br.readLine();
			String Q = br.readLine();
			
			int lenP = P.length();
			int lenQ = Q.length();
			
			String result = "Y";
			// Q가 P보다 1글자 길고, 맨 앞부터 P와 같고, 마지막 글자가 a일때만 두 단어 사이에 다른 단어가 없다.
			if( lenQ - lenP == 1 && Q.indexOf(P) == 0 && Q.charAt(lenQ-1) == 'a' ) result = "N";
			
			System.out.printf("#%d %s\n", tc, result);
		}
	}

}
