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
			
			int B = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			int Z = Integer.parseInt(st.nextToken());
			
			int max = Integer.MIN_VALUE;
			int pair = Math.min(B, W);
			if( 2 * Z > X + Y ) {
				max = pair * 2 * Z + (B - pair) * X + (W - pair) * Y;
			} else {
				max = B * X + W * Y;
			}
			System.out.printf("%d\n", max);
		}
	}

}
