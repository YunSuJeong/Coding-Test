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
			
			int m = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			int day = d;
			for(int i=1; i<m; i++) {
				if( i == 2 ) {
					day += 29;
				} else if ( i == 4 || i == 6 || i == 9 || i == 11 ) {
					day += 30;
				} else {
					day += 31;
				}
			}
			
			int remain = day % 7, date = 0;
			switch (remain) {
			case 1:
				date = 4; break;
			case 2:
				date = 5; break;
			case 3:
				date = 6; break;
			case 4:
				date = 0; break;
			case 5:
				date = 1; break;
			case 6:
				date = 2; break;
			case 0:
				date = 3; break;
			}
			
			System.out.printf("#%d %d\n", tc, date);
		}
	}

}
