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
			
			int[] A = new int[N];
			int[] B = new int[N];
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				A[i] = Integer.parseInt(st.nextToken());
				B[i] = Integer.parseInt(st.nextToken());
			}
			
			int cnt = 0;
			for(int i=0; i<N; i++) {
				for(int j=i+1; j<N; j++) {
					if( (A[i] < A[j] && B[i] > B[j]) || ( A[i] > A[j] && B[i] < B[j] ) ) cnt++;
				}
			}
			System.out.printf("#%d %d\n", tc, cnt);
		}
	}

}
