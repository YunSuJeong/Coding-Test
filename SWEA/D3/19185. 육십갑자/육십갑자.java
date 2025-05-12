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
			
			StringTokenizer Si = new StringTokenizer(br.readLine());
			StringTokenizer Ti = new StringTokenizer(br.readLine());
			
			String[] arrS = new String[N];
			String[] arrT = new String[M];
			for(int i=0; i<N; i++) {
				arrS[i] = Si.nextToken();
			}
			for(int i=0; i<M; i++) {
				arrT[i] = Ti.nextToken();
			}
			
			String[] arr = new String[N*M];		// 년도 체계
			int y = 1, i1 = 0, i2 = 0;
			while( y <= N * M ) {
				arr[y%(N*M)] = arrS[i1] + arrT[i2];
				
				i1++;
				i2++;
				y++;
				
				if( i1 >= N ) i1 %= N;
				if( i2 >= M ) i2 %= M;
			}
			
			int Q = Integer.parseInt(br.readLine());
			for(int i=0; i<Q; i++) {
				int year = Integer.parseInt(br.readLine());
				
				sb.append(arr[year%(N*M)]+" ");
			}
			System.out.printf("#%d %s\n", tc, sb.toString());
			sb.setLength(0);
		}
	}

}
