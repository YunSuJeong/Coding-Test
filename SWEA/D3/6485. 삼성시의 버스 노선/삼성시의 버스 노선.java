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
			int[] arr = new int[5000];			// 각 버스정류장의 노선 개수
			
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				int A = Integer.parseInt(st.nextToken()) - 1;
				int B = Integer.parseInt(st.nextToken()) - 1;
				
				for(int j=A; j<=B; j++) {
					arr[j]++;
				}
			}
			
			int P = Integer.parseInt(br.readLine());
			for(int i=0; i<P; i++) {
				int p = Integer.parseInt(br.readLine()) - 1;
				sb.append(arr[p]+" ");
			}
			System.out.printf("#%d %s\n", tc, sb.toString());
			
			sb.setLength(0);
		}
	}

}
