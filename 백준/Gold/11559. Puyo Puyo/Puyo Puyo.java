import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	public static int cnt = 0;
	public static char[][] arr = new char[12][6];
	public static boolean[][] visited = new boolean[12][6];
	
	public static int[] X = {-1, 1, 0, 0};
	public static int[] Y = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0; i<12; i++) {
			String str = br.readLine();
			for(int j=0; j<6; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		
		int chain = 0;
		while( true ) {
			boolean flag = false;
			for(int i=11; i>=0; i--) {
				for(int j=0; j<6; j++) {
					if( arr[i][j] != '.' && !visited[i][j] ) {
						
						for(boolean[] v : visited) Arrays.fill(v, false); 
						bfs(i,j);
						
						// 4개 이상 연결된 뿌요 터트리기
						if( cnt >= 4 ) {
							flag = true;
							pop();
						}
						cnt = 0;
					}
				}
			}
			// 더 터질 뿌요가 없다면 나가기
			if( !flag ) break;
			
			chain++;
			
			// 뿌요들이 없어진 후, 중력의 영향 받은 맵 세팅
			for(int i=0; i<6; i++) {
				int p1 = 11, p2 = 11;		
				while( p1 >= 0 && p2 >= 0) {
					// 비어있는 맨 아래로 떨어뜨리기
					if( arr[p1][i] == '.' && arr[p2][i] != '.' ) {
						arr[p1][i] = arr[p2][i];
						arr[p2][i] = '.';
					}

					if( arr[p1][i] != '.' ) p1--;
					if( arr[p2][i] == '.' ) p2--;
					
					if( p1 < p2 ) {
						p2 = p1 - 1;
					}
				}
			}
		}
		System.out.println(chain);
	}
	
	public static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {x, y});
		cnt = 1;
		
		while( !queue.isEmpty() ) {
			int[] tmp = queue.poll();
			x = tmp[0];
			y = tmp[1];

			visited[x][y] = true;
			
			for(int i=0; i<4; i++) {
				int a = x + X[i];
				int b = y + Y[i];
				
				if( a >= 0 && a < 12 && b >= 0 && b < 6 && !visited[a][b] && arr[a][b] == arr[x][y] ) {
					queue.offer(new int[] {a, b});
					cnt++;
				}
			}
		}
	}
	
	public static void pop() {
		for(int i=11; i>=0; i--) {
			for(int j=0; j<6; j++) {
				if( visited[i][j] && arr[i][j] != '.' ) {
					arr[i][j] = '.';
				}
			}
		}
	}
}
