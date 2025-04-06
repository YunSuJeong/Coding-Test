import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static int N, M, X;
	public static int[][] arr;
	public static boolean[][] visited;
	
	// 이동 방향
	//public static int[] arrX = {-1, -1, -1, 0, 1, 1, 1, 0};
	//public static int[] arrY = {-1, 0, 1, 1, 1, 0, -1, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		arr = new int[N][M];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		X = Integer.parseInt(br.readLine());
		visited = new boolean[N][M];
		if( arr[0][0] == arr[N-1][M-1] ) bfs(0, 0);
		
		if( visited[N-1][M-1] ) System.out.println("ALIVE");
		else System.out.println("DEAD");
	}
	
	public static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {x, y});
		
		visited[x][y] = true;
		
		while( !queue.isEmpty() ) {
			int[] tmp = queue.poll();
			
			x = tmp[0];
			y = tmp[1];
			
			// 맨해튼 거리 조건만 체크
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					int dist = Math.abs(x-i) + Math.abs(y-j);
					
					if( dist<= X && arr[i][j] == arr[x][y] && !visited[i][j]) {
						queue.offer(new int[] {i, j});
						visited[i][j] = true;
					}
				}
			}
			
			// 인접한 8방향으로 이해하고 푼 풀이 -> 틀림
			/*for(int i=0; i<8; i++) {
				int a = x + arrX[i];
				int b = y + arrY[i];
				int dist;
				while( true ) {
					dist = Math.abs(x-a) + Math.abs(y-b);
					
					if( dist > X ) break;
					
					if( a >= 0 && a < N && b >= 0 && b < M && arr[a][b] == arr[x][y] && !visited[a][b]) {
						queue.offer(new int[] {a, b});
						visited[a][b] = true;
					}
					
					a += arrX[i];
					b += arrY[i];
				}
			}*/
		}
	}

}
