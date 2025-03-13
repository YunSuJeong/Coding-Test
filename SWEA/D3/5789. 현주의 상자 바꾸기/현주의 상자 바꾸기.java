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
			int Q = Integer.parseInt(st.nextToken());
			
			// 상자 값 변경
			int[] arr = new int[N];
			for(int i=1; i<=Q; i++) {
				StringTokenizer change = new StringTokenizer(br.readLine());
				
				int L = Integer.parseInt(change.nextToken());
				int R = Integer.parseInt(change.nextToken());
				
				for(int j=L-1; j<=R-1; j++) {
					arr[j] = i;
				}
			}
			for(int n : arr) {
				sb.append(n+" ");
			}
			System.out.printf("#%d %s\n", tc, sb.toString());
            sb.setLength(0);
		}
	}

}
