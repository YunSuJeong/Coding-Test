import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static int min = 100;
	public static int[][] arr = new int[5][5];
	
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
		
		StringTokenizer student = new StringTokenizer(br.readLine());
		int stuX = Integer.parseInt(student.nextToken());
		int stuY = Integer.parseInt(student.nextToken());
		
		boolean[][] visited = new boolean[5][5];
		dfs(visited, stuX, stuY, 0, 0);
		
		System.out.println(min < 100 ? min : -1);
	}
	
	public static void dfs(boolean[][] visited, int x, int y, int dist, int apple) {
		visited[x][y] = true;
		
		if( arr[x][y] == 1 ) apple++;
		
		if( apple == 3 ) {
			min = Math.min(min, dist);
			visited[x][y] = false;
			return;
		}
		
		for(int i=0; i<4; i++) {
			int a = x + X[i];
			int b = y + Y[i];
			if( a < 5 && b < 5 && a >= 0 && b >= 0 && arr[a][b] != -1 && !visited[a][b] ) {
				dfs(visited, a, b, dist+1, apple);
			}
		}
		
		visited[x][y] = false;
	}

}
