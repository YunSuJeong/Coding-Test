import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer rect = new StringTokenizer(br.readLine());
			
			int x1 = Integer.parseInt(rect.nextToken());
			int y1 = Integer.parseInt(rect.nextToken());
			int x2 = Integer.parseInt(rect.nextToken());
			int y2 = Integer.parseInt(rect.nextToken());
			
			int N = Integer.parseInt(br.readLine());
			int in = 0, line = 0, out = 0;
			for(int i=0; i<N; i++) {
				StringTokenizer dot = new StringTokenizer(br.readLine());
				
				int x = Integer.parseInt(dot.nextToken());
				int y = Integer.parseInt(dot.nextToken());
				
				if( ((x == x1 || x == x2) && (y >= y1 && y <= y2)) || ((y == y1 || y == y2) && (x >= x1 && x <= x2)) ) {
					line++;
				} else if( x > x1 && x < x2 && y > y1 && y < y2 ) {
					in++;
				} else {
					out++;
				}
			}
			System.out.printf("#%d %d %d %d\n", tc, in, line, out);
		}
	}

}
