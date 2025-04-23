import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static int R, C, N;
	public static int[][] arr, dist, rule;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		arr = new int[R][C];
		dist = new int[R][C];
		
		for(int i=0; i<R; i++) {
			StringTokenizer road = new StringTokenizer(br.readLine());
			for(int j=0; j<C; j++) {
				arr[i][j] = Integer.parseInt(road.nextToken());
			}
		}
		
		// 규칙 저장
		N = Integer.parseInt(br.readLine());
		rule = new int[N][2];
		for(int i=0; i<N; i++) {
			StringTokenizer r = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(r.nextToken());
			int y = Integer.parseInt(r.nextToken());
			
			rule[i][0] = x;
			rule[i][1] = y;
		}
		
		for(int[] d : dist) {
			Arrays.fill(d, -1);
		}
		
		// 출근
		bfs();
		int min = Integer.MAX_VALUE;
		for(int i=0; i<C; i++) {
			if( dist[R-1][i] != -1 ) min = Math.min(min, dist[R-1][i]);
		}
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}

	public static void bfs() {
		Queue<int[]> queue = new LinkedList<int[]>();
		
		// 출근가능한 모든 블럭 한번에 넣기
		for(int i=0; i<C; i++) {
			if( arr[0][i] > 0 ) {
				dist[0][i] = 0;
				queue.offer(new int[] {0, i});
			}
		}
		
		while( !queue.isEmpty() ) {
			int[] tmp = queue.poll();
			
			int x = tmp[0];
			int y = tmp[1];
			
			for(int i=0; i<N; i++) {
				int a = x + rule[i][0];
				int b = y + rule[i][1];
				
				if( a >= 0 && a < R && b >= 0 && b < C && arr[a][b] > 0 && dist[a][b] == -1 ) {
					queue.offer(new int[] {a, b});
					dist[a][b] = dist[x][y] + 1;
				}
			}
		}
		
	}
}
