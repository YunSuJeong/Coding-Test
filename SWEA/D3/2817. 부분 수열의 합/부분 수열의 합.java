import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	public static int cnt = 0, N, K;
	public static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			StringTokenizer A = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			arr = new int[N];
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(A.nextToken());
			}
			
			dfs(0, 0);
			
			System.out.printf("#%d %d\n", tc, cnt);
			
			// 전역변수이므로 매 테스트 케이스마다 초기화
			cnt = 0;	
		}
	}
	
	public static void dfs(int depth, int sum) {
		if( depth == N ) {
			if( sum == K ) cnt++;
			return;
		}
		
		// 현재 요소를 부분집합에 포함하는 경우
		dfs(depth+1, sum + arr[depth]);
		// 부분집합에 포함하지 않는 경우
		dfs(depth+1, sum);
	}

}
