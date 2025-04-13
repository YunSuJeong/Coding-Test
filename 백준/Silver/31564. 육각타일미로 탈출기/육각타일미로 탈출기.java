import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static int N, M;
	public static int[][] arr, dist;
	
	public static int[] odd_X = {-1, -1, 0, 1, 1, 0};
	public static int[] odd_Y = {0, 1, 1, 1, 0, -1};
	public static int[] even_X = {-1, -1, 0, 1, 1, 0};
	public static int[] even_Y = {-1, 0, 1, 0, -1, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		dist = new int[N][M];
		for(int[] d : dist) {
			Arrays.fill(d, -1);
		}
		for(int i=0; i<K; i++) {
			StringTokenizer block = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(block.nextToken());
			int y = Integer.parseInt(block.nextToken());
			
			arr[x][y] = 1;
		}
		
		bfs(0, 0);
		
		System.out.println(dist[N-1][M-1]);
	}
	
	public static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<int[]>();
		
		queue.offer(new int[] {x, y});
		dist[x][y] = 0;
		
		while( !queue.isEmpty() ) {
			int[] tmp = queue.poll();
			
			x = tmp[0];
			y = tmp[1];
			
			for(int i=0; i<6; i++) {
				int a, b;
				if( x % 2 == 0 ) {
					a = x + even_X[i];
					b = y + even_Y[i];
				} else {
					a = x + odd_X[i];
					b = y + odd_Y[i];
				}
				
				if( a >= 0 && a < N && b >= 0 && b < M && dist[a][b] == -1 && arr[a][b] == 0) {
					queue.offer(new int[] {a, b});
					dist[a][b] = dist[x][y] + 1;
				}
			}
		}
	}

}
