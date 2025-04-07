import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	public static int bx = 0, by = 0, lx = 0, ly = 0;
	public static int dist[][] = new int[10][10];
	public static char arr[][] = new char[10][10];
	
	public static int[] X = {-1, 1, 0, 0};
	public static int[] Y = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0; i<10; i++) {
			String str = br.readLine();
			
			// 입력 
			for(int j=0; j<10; j++) {
				arr[i][j] = str.charAt(j);
				if( arr[i][j] == 'B' ) {
					bx = i;
					by = j;
				} else if( arr[i][j] == 'L' ) {
					lx = i;
					ly = j;
				}
				dist[i][j] = -1;
			}
		}
		
		// 최단 거리 구하기
		bfs(lx, ly);
		
		System.out.println(dist[bx][by]-1);
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
				if( a >= 0 && a < 10 && b >= 0 && b < 10 && dist[a][b] == -1 && arr[a][b] != 'R' ) {
					queue.offer(new int[] {a, b});
					dist[a][b] = dist[x][y] + 1;
				}
			}
		}
	}
}
