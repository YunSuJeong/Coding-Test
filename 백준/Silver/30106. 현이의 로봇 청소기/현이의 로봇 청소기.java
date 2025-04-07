import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static int N, M, K;
	public static int[][] arr;
	public static boolean[][] visited;
	
	public static int[] X = {-1, 1, 0, 0};
	public static int[] Y = {0, 0, -1, 1};
 	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		visited = new boolean[N][M];
		for(int i=0; i<N; i++) {
			StringTokenizer H = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(H.nextToken());
			}
		}
		
		int min = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if( !visited[i][j] ) {
					bfs(i, j);
					min++;
				}
			}
		}
		System.out.println(min);
	}
	
	public static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<int[]>();
		
		queue.offer(new int[] {x, y});
		visited[x][y] = true;
		
		while( !queue.isEmpty() ) {
			int[] tmp = queue.poll();
			
			x = tmp[0];
			y = tmp[1];
			
			for(int i=0; i<4; i++) {
				int a = x + X[i];
				int b = y + Y[i];
				
				if( a >= 0 && a < N && b >= 0 && b < M && !visited[a][b] && Math.abs(arr[x][y]-arr[a][b]) <= K ) {
					queue.offer(new int[] {a, b});
					visited[a][b] = true;
				}
			}
		}
	}
}
