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
			
			int max = Integer.MIN_VALUE;
			int[][] arr = new int[N][M];
			int[] cnt = new int[N];
			
			for(int i=0; i<N; i++) {
				StringTokenizer solve = new StringTokenizer(br.readLine());
				int sum = 0;
				for(int j=0; j<M; j++) {
					arr[i][j] = Integer.parseInt(solve.nextToken());
					sum += arr[i][j];
				}
				max = Math.max(max, sum);
				cnt[i] = sum;
			}
			
			int first = 0;
			for(int c : cnt ) {
				if( max == c ) {
					first++;
				}
			}
			System.out.printf("#%d %d %d\n", tc, first, max);
		}
	}

}
