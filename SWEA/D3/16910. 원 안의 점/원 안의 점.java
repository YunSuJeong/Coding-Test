import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			int cnt = 0;
			for(int i=N*-1; i<=N; i++) {
				for(int j=N*-1; j<=N; j++) {
					if( i*i + j*j <= N*N ) cnt++;
				}
			}
			System.out.printf("#%d %d\n", tc, cnt);
		}
	}

}
