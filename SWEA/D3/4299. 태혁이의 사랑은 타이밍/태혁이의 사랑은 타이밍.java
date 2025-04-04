import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int D = Integer.parseInt(st.nextToken());
			int H = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
//			int sum = 0;
//			if( D <= 11 && H <= 11 && M <= 10 ) sum = -1;
//			else {
//				M -= 11;
//				if( M < 0 ) {
//					H--;
//					M += 60;
//				} 
//				H -= 11;
//				if( H < 0 ) {
//					D--;
//					H += 24;
//				}
//				D -= 11;
//				System.out.println(D+" "+H+" "+M);
//				sum = M + H * 60 + D * 24 * 60;
//			}
			int snack = 11 + 11 * 60 + 11 * 24 * 60;
			int sum = M + H * 60 + D * 24 * 60;
			
			System.out.printf("#%d %d\n", tc, sum - snack < 0 ? -1 : sum - snack);
		}
	}

}
