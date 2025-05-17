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
			
			int[] arr = new int[N];
			int max = Integer.MIN_VALUE;
			for(int i=0; i<N; i++) {
				int sum = 0;
				StringTokenizer yn = new StringTokenizer(br.readLine());
				for(int j=0; j<M; j++) {
					sum += Integer.parseInt(yn.nextToken());
				}
				arr[i] = sum;
				max = Math.max(max, arr[i]);
			}
			
			int win = 0;
			for(int i=0; i<N; i++) {
				if( max == arr[i] ) {
					win++;
				}
			}
			System.out.printf("#%d %d %d\n", tc, win, max);
		}
	}

}
