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
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			String[] arr = new String[N];
			for(int i=0; i<N; i++) {
				arr[i] = st.nextToken();
			}
			
			int mid = N % 2 == 0 ? N/2 : (N+1)/2;
			int p1 = 0, p2 = mid;
			while( p1 < mid || p2 < N ) {
				if( p1 < mid ) sb.append(arr[p1]+" ");
				if( p2 < N ) sb.append(arr[p2]+" ");
				p1++;
				p2++;
			}
			System.out.printf("#%d %s\n", tc, sb.toString());
			sb.setLength(0);
		}
	}

}
