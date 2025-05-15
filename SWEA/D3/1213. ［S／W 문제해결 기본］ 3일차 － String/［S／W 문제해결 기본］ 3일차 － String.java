import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1; tc<=10; tc++) {
			int T = Integer.parseInt(br.readLine());
			
			String str1 = br.readLine();
			String str2 = br.readLine();
			
			int cnt = 0;
			while( str2.indexOf(str1) >= 0 ) {
				str2 = str2.replaceFirst(str1, ".");
				cnt++;
			}
			System.out.printf("#%d %d\n", T, cnt);
		}
	}

}
