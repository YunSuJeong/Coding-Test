import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] view = {-2, -1, 1, 2};		// 조망권 확보를 위한 탐색 범위
		
		for(int tc=1; tc<=10; tc++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int[] building = new int[N];
			for(int i=0; i<N; i++) {
				building[i] = Integer.parseInt(st.nextToken());
			}
			
			int cnt = 0;
			for(int i=2; i<N-2; i++) {
				int max = 0;
				for(int j=0; j<4; j++) {
					max = Math.max(max, building[i+view[j]]);
				}
				
				if( building[i] > max ) cnt += building[i] - max;
			}
			
			System.out.printf("#%d %d\n", tc, cnt);
		}
	}

}
