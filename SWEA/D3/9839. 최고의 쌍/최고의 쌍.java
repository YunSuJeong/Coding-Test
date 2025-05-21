import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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
			
			Arrays.sort(arr);
			
			int max = -1;
			for(int i=N-1; i>=1; i--) {
				for(int j=i-1; j>=0; j--) {
					int num = arr[i] * arr[j];
					int n = num % 10;
					boolean flag = true;
					
					while( num > 0 ) {
						if( num % 10 != n ) {
							flag = false;
							break;
						}
						
						num /= 10;
						n--;
					}
					
					if(flag) {
						max = arr[i] * arr[j];
						break;
					}
				}
				if( max > 0 ) break;
			}
			System.out.printf("#%d %d\n", tc, max);
		}
	}

}
