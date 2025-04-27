import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			int[][] arr = new int[N][N];
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int[] cnt = new int[N];
			cnt[0] = 0;
			cnt[1] = arr[0][1] == 2 ? 0 : 1;
			for(int i=2; i<N; i++) {
				if( arr[0][i] != i + 1 ) {
					if( arr[0][i-1] != i ) {
						cnt[i] = cnt[i-1];
					} else {
						cnt[i] = cnt[i-1] + 2;
 					}
				} else {
					cnt[i] = cnt[i-1];
				}
			}
			System.out.println(cnt[N-1]);
		}
	}

}
