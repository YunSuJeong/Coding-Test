import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	
	public static int N, M;
	public static boolean flag = true;
	public static int[][] arr;
	public static boolean[][] visited;
	
	public static int[] X = {-1, 1, 0, 0};
	public static int[] Y = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			arr = new int[N][M];
			visited = new boolean[N][M];
			
			for(int i=0; i<N; i++) {
				String str = br.readLine();
				for(int j=0; j<M; j++) {
					char c = str.charAt(j);
					int n = 0;
					if( c == '#' ) n = 1;				// 흑 : 1
					else if( c == '.' ) n = 2;			// 백 : 2
					arr[i][j] = n;
				}
			}
			
			// 1) 확인해야하는 두가지 경우 나누어 해결
			/*flag = true;
			// 흑으로 시작하는 격자판
			for(int i=0; i<N; i++) {
				int n = i % 2 == 0 ? 1 : 2;
				for(int j=0; j<M; j++) {
					if( arr[i][j] > 0 ) {
						if( arr[i][j] != n ) {
							flag = false;
							break;
						}
					}
					n = n == 1 ? 2 : 1;
				}
				if( !flag ) break;
			}

			// 백으로 시작하는 격자판
			if( !flag ) {
				flag = true;
				for(int i=0; i<N; i++) {
					int n = i % 2 == 0 ? 2 : 1;
					for(int j=0; j<M; j++) {
						if( arr[i][j] > 0 ) {
							if( arr[i][j] != n ) {
								flag = false;
								break;
							}
						}
						n = n == 1 ? 2 : 1;
					}
					if( !flag ) break;
				}
			}*/
			
			// 2) bfs로 해결해보기
			flag = true;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if( arr[i][j] > 0 && flag ) bfs(i, j);
				}
			}
			
			System.out.printf("#%d %s\n", tc, flag ? "possible" : "impossible");
		}
	}
	
	public static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<int[]>();

		queue.offer(new int[] {x, y});
		visited[x][y] = true;
		
		while( !queue.isEmpty() ) {
			if( !flag ) break;
			
			int[] tmp = queue.poll();
			
			x = tmp[0];
			y = tmp[1];
			
			for(int i=0; i<4; i++) {
				int a = x + X[i];
				int b = y + Y[i];
				
				if( a >= 0 && a < N && b >= 0 && b < M && !visited[a][b] ) {
					if( arr[a][b] > 0 && arr[a][b] == arr[x][y] ) {
						flag = false;
						break;
					} else {
						visited[a][b] = true;
						queue.offer(new int[] {a, b});
						arr[a][b] = arr[x][y] == 1 ? 2 : 1;
					}
				}
			}
		}
	}

}
