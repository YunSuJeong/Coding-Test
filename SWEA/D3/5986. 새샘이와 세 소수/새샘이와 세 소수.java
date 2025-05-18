import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		boolean[] prime = new boolean[1000];
		for(int i=2; i*i<1000; i++) {
			for(int j=i*2; j<1000; j+=i) {
				if( !prime[j] ) prime[j] = true;
			}
		}
		
		int[] arr = new int[1000];
		for(int i=2; i<1000; i++) {
			if( !prime[i] ) {
				if( i*3 < 1000 && i*3 % 2 == 1 ) arr[i*3]++;				// i + i + i인 경우
				if( i+4 < 1000 && (i+4) % 2 == 1 ) arr[i+4]++;			// 2 + 2 + i인 경우
			}
		}
		// i + i + j 인 경우
		for(int i=3; i<1000; i++) {
			if( !prime[i] ) {
				for(int j=3; i*2+j<1000; j++) {
					if( i != j && !prime[j] && (i*2+j) % 2 == 1 ) arr[i*2+j]++;
				}
			}
		}
		
		// i + j + k 인 경우
		for(int i=3; i<1000; i++) {
			if( !prime[i] ) {
				for(int j=i+1; i+j<1000; j++) {
					if( !prime[j] && i != j ) {
						for(int k=j+1; i+j+k<1000; k++) {
							if( !prime[k] && j != k && i != k && (i+j+k) % 2 == 1 ) arr[i+j+k]++;
						}
					}
				}
			}
		}
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			System.out.printf("#%d %d\n", tc, arr[N]);
		}
	}

}
