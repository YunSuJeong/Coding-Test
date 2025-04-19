import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static int N, M;
	public static int[][] arr, dist;
	
	public static int[] X = {0, 1};
	public static int[] Y = {1, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		dist = new int[N][M];
		for(int i=0; i<N; i++) {
			StringTokenizer map = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(map.nextToken());
				dist[i][j] = -1;
			}
		}
		
		bfs(0, 0);
		
		System.out.println(dist[N-1][M-1]);
	}
	
	public static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<int[]>();
		
		queue.offer(new int[] {x, y});
		dist[x][y] = 0;
		
		while(!queue.isEmpty()) {
			int[] tmp = queue.poll();
			
			x = tmp[0];
			y = tmp[1];
			
			for(int i=0; i<2; i++) {
				int a = 0;
				int b = 0;
				
				for(int j=1; j<=arr[x][y]; j++) {
					a = x + X[i] * j;
					b = y + Y[i] * j;
					if( a >= 0 && a < N && b >= 0 && b < M && dist[a][b] == -1 ) {
						dist[a][b] = dist[x][y] + 1;
						queue.offer(new int[] {a, b});
					}
				}
			}
		}
	}
}
