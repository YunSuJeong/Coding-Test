import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static int n, m, max = 0, size = 0, cnt = 0;
	public static int[][] arr;
	
	public static int[] X = {-1, 1, 0, 0};
	public static int[] Y = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		
		for(int i=0; i<n; i++) {
			StringTokenizer paint = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(paint.nextToken());
			}
		}

		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if( arr[i][j] == 1 ) {
					size = 0;
					cnt++;
					dfs(i, j);
					
					max = Math.max(max, size);
				}
			}
		}
		System.out.println(cnt);
		System.out.println(max);
	}

	public static void dfs(int x, int y) {
		arr[x][y] = -1;
		size++;
		
		for(int i=0; i<4; i++) {
			int a = x + X[i];
			int b = y + Y[i];
			
			if( a >= 0 && a < n && b >= 0 && b < m && arr[a][b] == 1 ) {
				dfs(a, b);
			}
		}
	}
}
