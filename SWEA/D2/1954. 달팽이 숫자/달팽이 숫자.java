import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	
	// 시계방향
	public static int N, num;
	public static int[][] arr;
	public static int[] X = {0, 1, 0, -1};
	public static int[] Y = {1, 0, -1, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			
			arr = new int[N][N];
			
			num = 1;
			snail(0, 0, 0);
			
			// 출력
			System.out.printf("#%d\n", tc);
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					System.out.print(arr[i][j]+" ");
				}
				System.out.println();
			}
		}
	}
	
	public static void snail(int x, int y, int d) {
		arr[x][y] = num;
		num++;
		
		int a = x + X[d];
		int b = y + Y[d];
		
		if( a >= 0 && a < N && b >= 0 && b < N && arr[a][b] == 0 ) {
			snail(a, b, d);
		} else {
			d = (d+1)%4;
			a = x + X[d];
			b = y + Y[d];
			if( a >= 0 && a < N && b >= 0 && b < N && arr[a][b] == 0 ) snail(a, b, d);
		}
	}
}
