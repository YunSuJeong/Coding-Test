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
			
			int sum = 0;
			for(int i=0; i<5; i++) {
				int score = Integer.parseInt(st.nextToken());
				
				sum += score < 40 ? 40 : score;
			}
			System.out.printf("#%d %d\n", tc, sum/5);
		}
	}

}
