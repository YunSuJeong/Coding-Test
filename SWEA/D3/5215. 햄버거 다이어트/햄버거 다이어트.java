import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	public static int max = 0, N, L;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());		// 재료 수
			L = Integer.parseInt(st.nextToken());		// 제한 칼로리
			
			int[][] arr = new int[N][2];
			for(int i=0; i<N; i++) {
				StringTokenizer input = new StringTokenizer(br.readLine());
				
				int k = Integer.parseInt(input.nextToken());
				int t = Integer.parseInt(input.nextToken());
				
				arr[i][0] = t;			// 칼로리
				arr[i][1] = k;			// 맛에 대한 점수
			}
			
			// 햄버거 점수 최댓값 구하기
			order(arr, 0, 0, 0);
			
			System.out.printf("#%d %d\n", tc+1, max);
			max = 0;
		}
	}
	
	public static void order(int[][] arr, int idx, int curr, int score) {
		if( curr > L ) return;
		
		if( idx == N ) {
			max = Math.max(max, score);
			return;
		} 
		
		// 현재 재료 넣는 경우
		order(arr, idx+1, curr + arr[idx][0], score + arr[idx][1]);
		
		// 넣지 않는 경우
		order(arr, idx+1, curr, score);
	}
}
