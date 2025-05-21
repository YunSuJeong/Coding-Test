import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			int[] arr = new int[N];
			boolean[] check = new boolean[N];
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(br.readLine());
			}
			
			int cnt = 0;
			for(int i=1; i<N; i++) {
				// 즐거운 날이지만 주기가 계산되지 않은 배일 때
				if( !check[i] ) {
					cnt++;
					int term = arr[i] - arr[0];
					for(int j=i+1; j<N; j++) {
						if( (arr[j] - arr[i]) % term == 0 ) check[j] = true;
					}
				}
			}
			System.out.printf("#%d %d\n", tc, cnt);
		}
	}

}
