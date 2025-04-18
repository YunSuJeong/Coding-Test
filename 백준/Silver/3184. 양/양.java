import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static int R, C, o = 0, v = 0;
	public static char[][] arr;
	public static boolean[][] visited;

	public static int[] X = {-1, 1, 0, 0};
	public static int[] Y = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		arr = new char[R][C];
		visited = new boolean[R][C];
		for(int i=0; i<R; i++) {
			String str = br.readLine();
			for(int j=0; j<C; j++) {
				arr[i][j] = str.charAt(j);
			}
		}

		int sheep = 0, wolf = 0;
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if( !visited[i][j] && arr[i][j] != '#' ) {
					dfs(i, j);
					
					if( o > v ) sheep += o;			// 늑대 우리에서 쫓아냄
					else wolf += v;					// 늑대가 양을 다 먹음
					
					o = 0;
					v = 0;
				}
			}
		}
		
		System.out.println(sheep+" "+wolf);
	}
	
	public static void dfs(int x, int y) {
		visited[x][y] = true;
		
		if( arr[x][y] == 'o' ) o++;
		if( arr[x][y] == 'v' ) v++;
		
		for(int i=0; i<4; i++) {
			int a = x + X[i];
			int b = y + Y[i];
			
			if( a >= 0 && a < R && b >= 0 && b < C && !visited[a][b] && arr[a][b] != '#' ) {
				dfs(a, b);
			}
		}
	}

}
