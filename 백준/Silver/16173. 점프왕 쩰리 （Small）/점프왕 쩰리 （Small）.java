import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static int[][] arr;
	public static int N;
	public static boolean flag = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		// 게임 구역 세팅
		arr = new int[N][N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 경로 탐색
		boolean[][] visited = new boolean[N][N];
		dfs(visited, 0, 0);
		
		System.out.println(flag ? "HaruHaru" : "Hing" );
	}
	
	public static void dfs(boolean[][] visited, int x, int y) {
		if( flag ) return;
		
		visited[x][y] = true;
		if( x == N-1 && y == N-1 ) {
			flag = true;
			return;
		}
		
		int num = arr[x][y];
		
		if( y+num < N && y+num >= 0 && !visited[x][y+arr[x][y]]) dfs(visited, x, y+arr[x][y]);		// 오른쪽 방향으로 이동
		if( x+num < N && x+num >= 0 && !visited[x+arr[x][y]][y]) dfs(visited, x+arr[x][y], y);		// 아래 방향으로 이동
	}

}
