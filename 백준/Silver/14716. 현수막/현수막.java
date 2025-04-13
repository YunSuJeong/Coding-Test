import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static int M, N;
	public static int[][] arr;
	
	// 상하좌우, 대각선
	public static int[] X = {-1, -1, -1, 0, 1, 1, 1, 0};
	public static int[] Y = {-1, 0, 1, 1, 1, 0, -1, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		arr = new int[M][N];
		for(int i=0; i<M; i++) {
			StringTokenizer bn = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(bn.nextToken());
			}
		}
		
		int cnt = 0;
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if( arr[i][j] > 0 ) {
					dfs(i, j);
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
	}
	
	public static void dfs(int x, int y) {
		arr[x][y] = 0;
		
		for(int i=0; i<8; i++) {
			int a = x + X[i];
			int b = y + Y[i];
			
			if( a >= 0 && a < M && b >= 0 && b < N && arr[a][b] > 0 ) dfs(a, b);
		}
	}

}
