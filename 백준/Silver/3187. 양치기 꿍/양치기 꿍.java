import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static int R, C, v = 0, k = 0, wolf = 0, sheep = 0;
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
		
		// 모든 영역의 양과 늑대 수 구하기
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if( !visited[i][j] && arr[i][j] != '#' ) {
					dfs(i, j);
					
					if( k > v ) sheep += k;
					else wolf += v;
					
					k = 0;
					v = 0;
				}
			}
		}
		
		System.out.println(sheep+" "+wolf);
	}

	// 울타리 안 양/늑대 수 구하기
	public static void dfs(int x, int y) {
		visited[x][y] = true;
		
		if( arr[x][y] == 'v' ) v++;
		if( arr[x][y] == 'k' ) k++;
		
		for(int i=0; i<4; i++) {
			int a = x + X[i];
			int b = y + Y[i];
			if( a >= 0 && a < R && b >=0 && b < C && !visited[a][b] && arr[a][b] != '#' ) dfs(a, b);
		}
	}
}
