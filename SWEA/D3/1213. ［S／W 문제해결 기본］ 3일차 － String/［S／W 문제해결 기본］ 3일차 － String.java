import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1; tc<=10; tc++) {
			int N = Integer.parseInt(br.readLine());
			String word = br.readLine();
			String str = br.readLine();
			
			int cnt = 0;
			while( str.indexOf(word) >= 0 ) {
				cnt++;
				
				str = str.replaceFirst(word, ".");
			}
			
			System.out.printf("#%d %d\n", N, cnt);
		}
	}

}
