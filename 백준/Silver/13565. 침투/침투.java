import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static int M, N;
	public static boolean flag = false;
	public static int[][] arr;
	
	// 상, 하, 좌, 우 탐색
	public static int[] X = {-1, 1, 0, 0};
	public static int[] Y = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new int[M][N];
		
		for(int i=0; i<M; i++) {
			String str = br.readLine();
			int j = 0;
			for(String s : str.split("")) {
				arr[i][j] = Integer.parseInt(s);
				j++;
			}
		}
		
		boolean[][] visited = new boolean[M][N];
		for(int i=0; i<N; i++) {
			if( !flag && arr[0][i] == 0 ) dfs(visited, 0, i); 
		}
		
		if( flag ) System.out.println("YES");
		else System.out.println("NO");
	}
	
	public static void dfs(boolean[][] visited, int x, int y) {
		// 이미 안쪽까지 전류가 통했다면 바로 리턴
		if( flag ) return;

		if( x == M-1 ) {
			flag = true;
			return;
		}
		
		visited[x][y] = true;
		
		for(int i=0; i<4; i++) {
			int a = x + X[i];
			int b = y + Y[i];
			
			if( a >= 0 && a < M && b >=0 && b < N && !visited[a][b] && arr[a][b] == 0 )
				dfs(visited, a, b);
		}
		
	}

}
