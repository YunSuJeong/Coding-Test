import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			String ori = br.readLine();
			String dict = br.readLine();
			
			int cnt = 0;
			for(int i=0; i<N; i++) {
				char c1 = ori.charAt(i);
				char c2 = dict.charAt(i);
				
				if( c1 == c2 ) cnt++;
			}
			
			System.out.printf("#%d %d\n", tc, cnt);
		}
	}

}
