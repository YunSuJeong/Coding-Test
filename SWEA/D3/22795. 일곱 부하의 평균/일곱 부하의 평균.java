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
			
			int sum = 0, max = Integer.MIN_VALUE;
			for(int i=0; i<6; i++) {
				int h = Integer.parseInt(st.nextToken());
				sum += h;
				max = Math.max(max, h);
			}
			
			int seven = 0, min = max + 1;
			while( true ) {
				if( (sum + min) % 7 == 0 ) {
					seven = min;
					break;
				}
				min++;
			}
			System.out.printf("%d\n", seven);
		}
	}

}
