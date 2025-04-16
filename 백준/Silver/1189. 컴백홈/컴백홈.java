import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static int R, C, K, cnt = 0;
	public static char[][] arr;
	
	public static int[] X = {-1, 1, 0, 0};
	public static int[] Y = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new char[R][C];
		for(int i=0; i<R; i++) {
			String str = br.readLine();
			for(int j=0; j<C; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		
		boolean[][] visited = new boolean[R][C];
		dfs(visited, 1, R-1, 0);
		
		System.out.println(cnt);
	}
	
	public static void dfs(boolean[][] visited, int len, int x, int y) {
		visited[x][y] = true;
		
		if(x == 0 && y == C-1) {
			if( len == K ) cnt++;
			visited[x][y] = false;
			return;
		}
		
		for(int i=0; i<4; i++) {
			int a = x + X[i];
			int b = y + Y[i];
			if( a >= 0 && a < R && b >= 0 && b < C && !visited[a][b] && arr[a][b] != 'T' ) 
				dfs(visited, len+1, a, b);
		}
		
		visited[x][y] = false;
	}

}
