import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static int N, M, BLUE = 0, WHITE = 0, b, w;
	public static char[][] arr;
	public static boolean[][] visited;
	
	public static int[] X = {-1, 1, 0, 0};
	public static int[] Y = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new char[M][N];
		visited = new boolean[M][N];
		
		for(int i=0; i<M; i++) {
			String str = br.readLine();
			for(int j=0; j<N; j++) {
				arr[i][j] = str.charAt(j);
			}
		}

		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if( !visited[i][j] ) {
					b = w = 0;
					dfs(arr[i][j], i, j);
					
					if( arr[i][j] == 'B' ) BLUE += b * b;
					else WHITE += w * w;
				}
			}
		}
		System.out.println(WHITE+" "+BLUE);
	}
	
	public static void dfs(char color, int x, int y) {
		visited[x][y] = true;
		
		if( color == 'B' ) b++;
		else w++;
		
		for(int i=0; i<4; i++) {
			int a = x + X[i];
			int b = y + Y[i];
			
			if( a >= 0 && a < M && b >= 0 && b < N && !visited[a][b] && arr[a][b] == color ) {
				dfs(color, a, b);
			}
		}
	}

}
