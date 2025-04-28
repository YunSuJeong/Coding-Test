import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static int n, m;
	public static int[][] arr, dist;
	
	public static int[] X = {-1, 1, 0, 0};
	public static int[] Y = {0, 0, -1, 1};
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		dist = new int[n][m];
		
		int x_ = 0, y_ = 0;
		for(int i=0; i<n; i++) {
			StringTokenizer map = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(map.nextToken());
				if( arr[i][j] == 2 ) {
					x_ = i;
					y_ = j;
				}
			}
		}
		
		for(int[] d : dist) {
			Arrays.fill(d, -1);
		}
		
		bfs(x_, y_);
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if( arr[i][j] == 1 ) {
					sb.append(dist[i][j]+" ");
				} else {
					sb.append(0+" ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
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
				int a = x + X[i];
				int b = y + Y[i];
				
				if( a >= 0 && a < n && b >= 0 && b < m && arr[a][b] > 0 && dist[a][b] == -1 ) {
					queue.offer(new int[] {a, b});
					dist[a][b] = dist[x][y] + 1;
				}
			}
		}
	}

}
