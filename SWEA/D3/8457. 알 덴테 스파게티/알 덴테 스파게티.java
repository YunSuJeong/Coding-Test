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
			int B = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			StringTokenizer Xi = new StringTokenizer(br.readLine());
			
			int[] arr = new int[N];
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(Xi.nextToken());
			}
			
			int cnt = 0;
			for(int i=0; i<N; i++) {
				for(int j=B/arr[i]; arr[i]*j<=B+E; j++) {
					if( arr[i] * j >= B - E && arr[i] * j <= B + E ) {
						cnt++;
						break;
					}
				}
			}
			System.out.printf("#%d %d\n", tc, cnt);
 		}
	}

}
