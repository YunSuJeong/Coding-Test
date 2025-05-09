import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int[] arr = new int[K];
			for(int i=0; i<N; i++) {
				for(int j=1; j<=K; j++) {
					int idx;
					if( i % 2 == 0 ) {
						// 순서대로
						idx = (i * K + j) % K == 0 ? K : (i * K + j) % K;
						arr[idx-1] += i * K + j;
					} else {
						// 역순
						idx = (i+2) * K - ((i+1) * K + j) + 1 ;
						arr[idx-1] += i * K + j;
					}
				}
			}
			
			for(int a : arr) {
				sb.append(a+" ");
			}
			System.out.printf("#%d %s\n", tc, sb.toString());
			sb.setLength(0);
		}
	}

}
