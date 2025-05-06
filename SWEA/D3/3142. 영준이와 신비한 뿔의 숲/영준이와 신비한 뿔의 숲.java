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
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			
			boolean flag = false;
			for(int i=0; i<=N; i++) {
				for(int j=0; j<=M; j++) {
					if( i+j == M && i + j * 2 == N ) {
						System.out.printf("#%d %d %d\n", tc, i, j);
						flag = true;;
					}
				}
				if( flag ) break;
			}
		}
	}

}
