import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static int N, M;
	public static int[][] dist;
	
	public static int[] X = {-2, -2, -1, -1, 1, 1, 2, 2};
	public static int[] Y = {-1, 1, -2, 2, -2, 2, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringTokenizer night = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		dist = new int[N][N];
		
		int X = Integer.parseInt(night.nextToken()) - 1;
		int Y = Integer.parseInt(night.nextToken()) - 1;
		
		for(int[] d : dist) {
			Arrays.fill(d, -1);
		}
		bfs(X, Y);			// 나이트에서 각 칸까지 최소거리 구하기
		
		for(int i=0; i<M; i++) {
			StringTokenizer e = new StringTokenizer(br.readLine());
			
			int A = Integer.parseInt(e.nextToken()) - 1;
			int B = Integer.parseInt(e.nextToken()) - 1;
			
			sb.append(dist[A][B]+"\n");
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
			
			for(int i=0; i<8; i++) {
				int a = x + X[i];
				int b = y + Y[i];
				
				if( a >= 0 && a < N && b >= 0 && b < N && dist[a][b] == -1 ) {
					queue.offer(new int[] {a, b});
					dist[a][b] = dist[x][y] + 1;
				}
			}
		}
		
	}
}
