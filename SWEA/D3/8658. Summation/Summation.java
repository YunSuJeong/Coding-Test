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
			
			int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
			for(int i=0; i<10; i++) {
				int num = Integer.parseInt(st.nextToken());
				int sum = 0;
				
				while( num > 0 ) {
					sum += num % 10;
					num /= 10;
				}
				
				max = Math.max(max, sum);
				min = Math.min(min, sum);
			}
			System.out.printf("#%d %d %d\n", tc, max, min);
		}
	}

}
