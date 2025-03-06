import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static int N, M, result;
	public static boolean flag = false;
	public static int[][] arr;
	public static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 지도 세팅
		arr = new int[M][N];
		visited = new boolean[M][N];
		for(int i=0; i<M; i++) {
			StringTokenizer map = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(map.nextToken());
			}
		}
		
		// 1. dfs
		dfs(0, 0);
		if( flag ) System.out.println("Yes");
		else System.out.println("No");
		
		// 2. bfs 
//		bfs();
//		if( visited[M-1][N-1] ) System.out.println("Yes");
//		else System.out.println("No");
	}
	
	public static void dfs(int x, int y) {
		if( x == M-1 && y == N-1 ) {
			flag = true;
			return;
		} 
		
		visited[x][y] = true;
		
		if( y + 1 < N && arr[x][y+1] > 0 && !visited[x][y+1] ) dfs(x, y+1);		// 동쪽
		if( x + 1 < M && arr[x+1][y] > 0 && !visited[x+1][y] ) dfs(x+1, y);		// 남쪽
	}
	
	/* public static void bfs() {
		Queue<int[]> queue = new LinkedList<int[]>();		// 탐색가능한 점만 저장하는 큐
		queue.add(new int[]{0, 0});				// 시작점 큐에 넣기
		visited[0][0] = true;
		
		while( !queue.isEmpty() ) {
			int[] curr = queue.poll();
			int x = curr[0], y = curr[1];
			
			if( x == M-1 && y == N-1 ) return;
			
			if( y + 1 < N && !visited[x][y+1] && arr[x][y+1] > 0 ) {			// 동쪽
				visited[x][y+1] = true;
				queue.add(new int[]{x, y+1});
			}
			
			if( x + 1 < M && !visited[x+1][y] && arr[x+1][y] > 0 ) {			// 남쪽
				visited[x+1][y] = true;
				queue.add(new int[] {x+1, y});
			}
		}
	}*/
}
