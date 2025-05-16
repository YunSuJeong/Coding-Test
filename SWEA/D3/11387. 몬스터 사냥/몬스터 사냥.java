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
			int L = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			
			long sum = 0;
			for(int i=0; i<N; i++) {
				sum += D + (D / 100 * i * L);
			}
			System.out.printf("#%d %d\n", tc, sum);
		}
	}

}
