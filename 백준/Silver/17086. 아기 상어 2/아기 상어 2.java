import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static int N, M;
	public static int[][] arr, dist; 
	public static boolean[][] visited; 
	
	public static int[] X = {-1, -1, -1, 0, 1, 1, 1, 0};
	public static int[] Y = {-1, 0, 1, 1, 1, 0, -1, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];			// 상어 공간
		dist = new int[N][M];			// 안전거리
		
		for(int i=0; i<N; i++) {
			StringTokenizer map = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(map.nextToken());
				dist[i][j] = 1000;
			}
		}
		
		// 각 상어위치에서의 안전거리 찾기
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if( arr[i][j] == 1 ) {
					visited = new boolean[N][M];
					bfs(i, j);
				}
			}
		}
		
		// 안전거리 최대값 찾기
		int max = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				max = Math.max(max, dist[i][j]);
			}
		}
		System.out.println(max);
	}

	public static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<int[]>();
		
		queue.offer(new int[] {x, y});
		dist[x][y] = 0;
		visited[x][y] = true;
		
		while( !queue.isEmpty() ) {
			int[] tmp = queue.poll();
			
			x = tmp[0];
			y = tmp[1];
			
			for(int i=0; i<8; i++) {
				int a = x + X[i];
				int b = y + Y[i];
				
				if( a >= 0 && a < N && b >= 0 && b < M && arr[a][b] == 0 && !visited[a][b] ) {
					queue.offer(new int[] {a, b});
					dist[a][b] = Math.min(dist[a][b], dist[x][y] + 1);
					visited[a][b] = true;
				}
			}
		}
	}
}
