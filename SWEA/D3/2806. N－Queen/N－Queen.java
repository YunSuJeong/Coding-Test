import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	
	public static int N, cnt = 0;
	public static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			
			int[] position = new int[N];
			for(int i=0; i<N; i++) {
				queen(0, i, position);
			}
			
			System.out.printf("#%d %d\n", tc, cnt);
			cnt = 0;
		}
	}
	
	public static void queen(int x, int y, int[] position) {
		if( x == N-1 ) {
			cnt++;
			return;
		}
		
		position[x] = y;			// x행에 놓인 퀸의 열의 위치
		
		for(int i=0; i<N; i++) {
			boolean flag = true;
			for(int j=0; j<=x; j++) {
				// 세로 공격 가능한 자리인지 체크
				if( i == position[j] ) {
					flag = false;
					break;
				}
				// 대각선
				if( Math.abs(x+1-j) / Math.abs(position[j]-i) == 1 && Math.abs(x+1-j) % Math.abs(position[j]-i) == 0 ) {
					flag = false;
					break;
				}
			}
            
			// 어떤 퀸에게도 공격하지 않는 자리라면 놓기
			if( flag ) queen(x+1, i, position);
		}
		
	}
}
