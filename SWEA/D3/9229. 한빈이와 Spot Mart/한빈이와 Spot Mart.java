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
			StringTokenizer a = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[] arr = new int[N];
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(a.nextToken());
			}
			
			int max = -1;
			for(int i=0; i<N; i++) {
				for(int j=i+1; j<N; j++) {
					if( arr[i]+arr[j] <= M ) max = Math.max(max, arr[i]+arr[j]);
				}
			}
			
			System.out.printf("#%d %d\n", tc, max);
		}
	}

}
