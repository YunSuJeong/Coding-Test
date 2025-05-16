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
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int[] arr = new int[N];
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int cnt = 0;
			for(int i=1; i<N-1; i++) {
				if( (arr[i] < arr[i-1] && arr[i] < arr[i+1]) || (arr[i] > arr[i-1] && arr[i] > arr[i+1]) )
					continue;
				else 
					cnt++;
			}
			System.out.printf("#%d %d\n", tc, cnt);
		}
	}

}
