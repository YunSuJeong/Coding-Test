import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	public static int N, M;
	public static int[][] arr;
	
	public static int[] X = {-1, -1, 0, 1, 1, 1, 0, -1};
	public static int[] Y = {0, 1, 1, 1, 0, -1, -1, -1};
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			arr = new int[N][N];
			
			// 첫 초기 세팅
			int idx = N/2;
			arr[idx-1][idx-1] = 2;
			arr[idx-1][idx] = 1;
			arr[idx][idx-1] = 1;
			arr[idx][idx] = 2;
			
			for(int i=0; i<M; i++) {
				StringTokenizer str = new StringTokenizer(br.readLine());
				
				int y = Integer.parseInt(str.nextToken())-1;
				int x = Integer.parseInt(str.nextToken())-1;
				int turn = Integer.parseInt(str.nextToken());
				
				arr[x][y] = turn;
				
				for(int j=0; j<8; j++) {
					int a = x + X[j];
					int b = y + Y[j];
					
					if( isChange(a, b, X[j], Y[j], turn) ) {
						while( a >= 0 && a < N && b >= 0 && b < N && arr[a][b] > 0 ) {
							if( arr[a][b] == turn ) break;
							
							if( arr[a][b] == 1 ) {
								arr[a][b] = 2;
							} else {
								arr[a][b] = 1;
							}
							a += X[j];
							b += Y[j];
						}
					}
				}
			}
			
			int black = 0, white = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if( arr[i][j] == 1 ) black++;
					if( arr[i][j] == 2 ) white++;
				}
			}
			System.out.printf("#%d %d %d\n", tc, black, white);
		}
	}
	
	public static boolean isChange(int x, int y, int _x, int _y, int turn) {
		boolean flag = false;
		
		while( x >= 0 && x < N && y >= 0 && y < N && arr[x][y] > 0 ) {
			if( arr[x][y] == turn ) {
				flag = true;
				break;
			}
			
			x += _x;
			y += _y;
		}
		return flag;
	}
}
