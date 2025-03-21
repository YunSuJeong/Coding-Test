import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static int r, c, min = -1;
	public static int[][] arr = new int[5][5];
	public static int[][] dist = new int[5][5];
	public static Queue<int[]> queueX = new LinkedList<int[]>();
	
	public static int[] X = {-1, 1, 0, 0};
	public static int[] Y = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0; i<5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<5; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		StringTokenizer stu = new StringTokenizer(br.readLine());
		r = Integer.parseInt(stu.nextToken());
		c = Integer.parseInt(stu.nextToken());
		
		bfs(r, c);
		
		System.out.println(min);
	}
	
	public static void bfs(int x, int y) {
		
		queueX.add(new int[] {x, y});
		
		while( !queueX.isEmpty() ) {
			
			int[] tmp = queueX.poll();
			x = tmp[0];
			y = tmp[1];
			
			if( arr[x][y] == 1 ) {
				min = dist[x][y];
				return;
			}
			
			// 상하좌우로 이동
			for(int i=0; i<4; i++) {
				int a = x + X[i];
				int b = y + Y[i];
				if( !(a == r && b == c) && a >= 0 && a < 5 && b >= 0 && b < 5 && arr[a][b] >= 0 && dist[a][b] == 0 ) {
					dist[a][b] = dist[x][y] + 1;
					queueX.add(new int[] {a, b});
				}
			}
			
		} 
		
	}

}
