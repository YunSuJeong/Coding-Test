import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static int N, r1 = 0, r2 = 0, c1 = 0, c2 = 0;
	public static int[][] dist;
	
	public static int[] X = {-2, -2, 0, 0, 2, 2};
	public static int[] Y = {-1, 1, -2, 2, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r1 = Integer.parseInt(st.nextToken());
		c1 = Integer.parseInt(st.nextToken());
		r2 = Integer.parseInt(st.nextToken());
		c2 = Integer.parseInt(st.nextToken());
		
		dist = new int[N][N];

		for(int[] d : dist) {
			Arrays.fill(d, -1);
		}
		
		bfs(r1, c1);
		
		System.out.println(dist[r2][c2]);
	}
	
	public static void bfs(int r, int c) {
		Queue<int[]> queue = new LinkedList<int[]>();
		
		queue.offer(new int[] {r, c});
		dist[r][c] = 0;
		
		while( !queue.isEmpty() ) {
			int[] tmp = queue.poll();
			
			r = tmp[0];
			c = tmp[1];
			
			for(int i=0; i<6; i++) {
				int a = r + X[i];
				int b = c + Y[i];
				
				if( a >= 0 && a < N && b >= 0 && b < N && dist[a][b] == -1 ) {
					queue.offer(new int[] {a, b});
					dist[a][b] = dist[r][c] + 1;
				}
			}
		}
	}

}
