import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	
	public static int[][] arr;
	public static int[] dx = {-1, 0, 1, 0};
	public static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1; tc<=10; tc++) {
			int t = Integer.parseInt(br.readLine());
			
			arr = new int[100][100];
			int sx = 0, sy = 0;
			for(int i=0; i<100; i++) {
				String maze = br.readLine();
				for(int j=0; j<100; j++) {
					int n = maze.charAt(j) - '0';
					if( n == 2 ) {
						sx = i;
						sy = j;
					}
					arr[i][j] = n;
				}
			}
			System.out.printf("#%d %d\n", t, isArrive(new boolean[100][100], sx, sy));
		}
	}
	
	public static int isArrive(boolean[][] visited, int x, int y) {
		if( arr[x][y] == 3 ) return 1;
		
		for(int i=0; i<4; i++) {
			int a = x + dx[i];
			int b = y + dy[i];
			if( a >= 0 && a < 100 && b >= 0 && b < 100 & arr[a][b] != 1 && !visited[a][b] ) {
				visited[x][y] = true;
				if( isArrive(visited, a, b) == 1 ) return 1;
				visited[x][y] = false;
			}
		}
		
		return 0;
	}

}
