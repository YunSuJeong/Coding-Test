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
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				// 최소 좌석 수 = N(이미 앉아있는 사람 수) + Ai 합 + Ai 중 최대값
				// 정렬 되어있을 때가 가장 최소 좌석 수임
				int max = 0, seats = N;
				for(int i=0; i<N; i++) {
					int A = Integer.parseInt(st.nextToken());
					seats += A;
					max = Math.max(max, A);
				}
				System.out.printf("#%d %d\n", tc, seats+max);
			}
	}

}
