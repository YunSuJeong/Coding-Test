import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static int N, M, K, cnt = 0;
	public static int[][] arr;

	public static int[] X = {-1, 1, 0, 0};
	public static int[] Y = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		for(int i=0; i<K; i++) {
			StringTokenizer food = new StringTokenizer(br.readLine());
			
			int r = Integer.parseInt(food.nextToken()) - 1;
			int c = Integer.parseInt(food.nextToken()) - 1;
			
			arr[r][c] = 1;			// 음식물
		}
		
		int max = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if( arr[i][j] > 0 ) {
					cnt = 0;
					dfs(i,j);
					
					max = Math.max(max, cnt);
				}
			}
		}
		System.out.println(max);
	}

	public static void dfs(int x, int y) {
		arr[x][y] = -1;
		cnt++;
		
		for(int i=0; i<4; i++) {
			int a = x + X[i];
			int b = y + Y[i];
			
			if( a >= 0 && a < N && b >= 0 && b < M && arr[a][b] > 0 ) 
				dfs(a, b);
		}
	}
}
