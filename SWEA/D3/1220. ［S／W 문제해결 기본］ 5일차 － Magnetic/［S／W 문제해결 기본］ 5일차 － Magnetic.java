import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1; tc<=10; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			int[][] arr = new int[N][N];
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int cnt = 0;
			for(int i=0; i<N; i++) {
				int state = 0;
				for(int j=0; j<N; j++) {
					if( arr[j][i] == 1 ) {
						state = 1;
					} else if( arr[j][i] == 2 ) {
						if( state == 1 ) cnt++;
						state = 0;
					}
				}
			}
			System.out.printf("#%d %d\n", tc, cnt);
		}
	}

}
