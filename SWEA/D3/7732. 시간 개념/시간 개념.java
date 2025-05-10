import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			String t1 = br.readLine();
			String t2 = br.readLine();
			
			int h1 = Integer.parseInt(t1.split(":")[0]);
			int h2 = Integer.parseInt(t2.split(":")[0]);
			int m1 = Integer.parseInt(t1.split(":")[1]);
			int m2 = Integer.parseInt(t2.split(":")[1]);
			int s1 = Integer.parseInt(t1.split(":")[2]);
			int s2 = Integer.parseInt(t2.split(":")[2]);
			
			int H = 0, M = 0, S = 0;
			if( h1 > h2 || (h1 == h2 && m1 > m2) || (h1 == h2 && m1 == m2 && s1 > s2)) {
				h2 += 24;
			}
			S = s2 - s1;
			M = m2 - m1;
			H = h2 - h1;
			
			if( S < 0 ) {
				S += 60;
				M--;
			}
			if( M < 0 ) {
				M += 60;
				H--;
			}
			System.out.printf("#%d %02d:%02d:%02d\n", tc, H, M, S);
		}
	}

}
