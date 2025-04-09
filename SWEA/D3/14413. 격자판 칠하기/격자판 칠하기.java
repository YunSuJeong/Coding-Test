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
			
			int[][] arr = new int[N][M];
			
			for(int i=0; i<N; i++) {
				String str = br.readLine();
				for(int j=0; j<M; j++) {
					char c = str.charAt(j);
					int n = 0;
					if( c == '#' ) n = 1;				// 흑 : 1
					else if( c == '.' ) n = 2;			// 백 : 2
					arr[i][j] = n;
				}
			}
			
			boolean flag = true;
			// 흑으로 시작하는 격자판
			for(int i=0; i<N; i++) {
				int n = i % 2 == 0 ? 1 : 2;
				for(int j=0; j<M; j++) {
					if( arr[i][j] > 0 ) {
						if( arr[i][j] != n ) {
							flag = false;
							break;
						}
					}
					n = n == 1 ? 2 : 1;
				}
				if( !flag ) break;
			}

			// 백으로 시작하는 격자판
			if( !flag ) {
                flag = true;
				for(int i=0; i<N; i++) {
					int n = i % 2 == 0 ? 2 : 1;
					for(int j=0; j<M; j++) {
						if( arr[i][j] > 0 ) {
							if( arr[i][j] != n ) {
								flag = false;
								break;
							}
						}
						n = n == 1 ? 2 : 1;
					}
					if( !flag ) break;
				}
			}
			
			System.out.printf("#%d %s\n", tc, flag ? "possible" : "impossible");
		}
	}

}
