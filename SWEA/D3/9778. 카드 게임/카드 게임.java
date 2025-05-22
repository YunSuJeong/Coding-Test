import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			int[] card = new int[12];
			for(int i=2; i<=11; i++) {
				if( i == 10 ) card[i] = 16;
				else card[i] = 4;
			}
			
			int sum = 0;
			for(int i=0; i<N; i++) {
				int n = Integer.parseInt(br.readLine());
				
				sum += n;
				card[n]--;
			}
			
			String result = "STOP";
			if( sum <= 10 ) {
				result = "GAZUA";
			} else if( sum < 21 ) {
				int down = 0, up = 0;
				for(int i=2; i<=21-sum; i++) {
					down += card[i];
				}
				
				for(int i=22-sum; i<=11; i++) {
					up += card[i];
				}
				
				if( down > up ) result = "GAZUA";
			} 
			System.out.printf("#%d %s\n", tc, result);
		}
	}

}
