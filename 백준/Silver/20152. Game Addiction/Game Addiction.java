import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static int H, N;
	public static long cnt = 0;
	public static int[][] arr = new int[31][31];
	
	public static int[] X = {1, 0, -1, 0};
	public static int[] Y = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		H = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		// 1. dfs : 시간초과
//		if( H == N ) cnt = 1;
//		else bfs(H, H);
//		System.out.println(cnt);
		
		long[][] dp = new long[31][31];
		if( H == N ) cnt = 1;
		else {
			if( H < N ) {
				for(int i=H; i<=N; i++) {
					for(int j=H; j<=N; j++) {
						if( j > i ) dp[i][j] = 0;
						else {
							if( j == H ) dp[i][j] = 1;
							else {
								dp[i][j] = dp[i-1][j] + dp[i][j-1];
							}
						}
					}
				}
			} else {
				for(int i=H; i>=N; i--) {
					for(int j=H; j>=N; j--) {
						if( j > i ) dp[i][j] = 0;
						else {
							if( i == H ) dp[i][j] = 1;
							else {
								dp[i][j] = dp[i+1][j] + dp[i][j+1];
							}
						}
					}
				}
			}
			cnt = dp[N][N];
		}
		System.out.println(cnt);
		
	}
	
	// 1. 시간초과
	/*public static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<int[]>();
		
		queue.offer(new int[]{x, y});
		
		while( !queue.isEmpty() ) {
			int[] tmp = queue.poll();
			
			x = tmp[0];
			y = tmp[1];
			
			if( x == N && y == N ) {
				cnt++;
				continue;
			}
			
			if( H < N ) {
				for(int i=0; i<2; i++) {
					int a = x + X[i];
					int b = y + Y[i];
					if( a >= H && a <= N && b >= H && b <= N && a >= b ) {
						queue.offer(new int[] {a,b});
					}
						
				}
			} else {
				for(int i=2; i<4; i++) {
					int a = x + X[i];
					int b = y + Y[i];
					if( a >= N && a <= H && b >= N && b <= H && a >= b ) 
						queue.offer(new int[] {a,b});
				}
			}
		}
	}*/

}
