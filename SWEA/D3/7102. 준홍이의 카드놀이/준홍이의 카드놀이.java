import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[] arr = new int[N+M+1];
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=M; j++) {
					arr[i+j]++;
				}
			}
			
			int max = 0;
			for(int i=1; i<=N+M; i++) {
				max = Math.max(max, arr[i]);
			}

			for(int i=1; i<=N+M; i++) {
				if( max == arr[i] ) sb.append(i+" ");
			}
			System.out.printf("#%d %s\n", tc, sb.toString());
			sb.setLength(0);
		}
	}

}
