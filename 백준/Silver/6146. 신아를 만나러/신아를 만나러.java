import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static int X, Y, N;
	public static boolean[][] arr = new boolean[1001][1001];
	public static int[][] dist = new int[1001][1001];
	
	public static int[] X_ = {-1, 1, 0, 0};
	public static int[] Y_ = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		X = Integer.parseInt(st.nextToken()) + 500;
		Y = Integer.parseInt(st.nextToken()) + 500;
		N = Integer.parseInt(st.nextToken());
		
		// 방문확인을 위해 최단 거리 -1로 세팅
		for(int[] d : dist) {
			Arrays.fill(d, -1);
		}
		
		for(int i=0; i<N; i++) {
			StringTokenizer water = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(water.nextToken());
			int y = Integer.parseInt(water.nextToken());
			
			arr[x+500][y+500] = true;			// 웅덩이
		}
		
		bfs(500, 500);
		
		System.out.println(dist[X][Y]);
	}
	
	public static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<int[]>();
		
		queue.offer(new int[] {x, y});
		dist[x][y] = 0;
		
		while( !queue.isEmpty() ) {
			int[] tmp = queue.poll();
			
			x = tmp[0];
			y = tmp[1];
			
			for(int i=0; i<4; i++) {
				int a = x + X_[i];
				int b = y + Y_[i];
				
				if( a >= 0 & a <= 1000 && b >= 0 && b <= 1000 && !arr[a][b] && dist[a][b] == -1 ) {
					dist[a][b] = dist[x][y] + 1;
					queue.offer(new int[] {a, b});
					
				}
				if(a == X && b == Y) break;		// 신아의 집에 도착했다면 조기 종료
			}
		}
	}

}
