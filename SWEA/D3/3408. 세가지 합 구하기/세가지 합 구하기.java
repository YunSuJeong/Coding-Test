import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			long N = Integer.parseInt(br.readLine());
			
			long S1 = N * (N+1) / 2;
			long S2 = N * N;
			long S3 = N * (2*N + 2) / 2;
			
			System.out.printf("#%d %d %d %d\n", tc, S1, S2, S3);
		}
	}

}
