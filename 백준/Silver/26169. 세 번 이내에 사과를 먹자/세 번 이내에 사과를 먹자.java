import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static int[][] arr = new int[5][5];
	public static boolean flag = false;
	
	// 방향 전환을 위한 배열 (상/하/좌/우)
	public static int[] a = {-1, 1, 0, 0};
	public static int[] b = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 격자 세팅
		for(int i=0; i<5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<5; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 현재 학생 위치
		StringTokenizer stu = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(stu.nextToken());
		int c = Integer.parseInt(stu.nextToken());
		
		// dfs로 탐색
		boolean[][] visited = new boolean[5][5];
		dfs(visited, 0, r, c, 0);
		
		System.out.println(flag ? 1 : 0);
	}
	
	public static void dfs(boolean[][] visited, int depth, int x, int y, int apple) {
		if( depth > 3 ) {
			return;
		}
		visited[x][y] = true;
		if( arr[x][y] == 1 ) apple++;
		
//		System.out.println(x+" "+y+" "+depth+" "+apple);
		
		if( apple >= 2 ) {
			flag = true;
			return;
		}
		
		for(int i=0; i<4; i++) {
			int X = x + a[i];
			int Y = y + b[i];
			if( X >= 0 && Y >= 0 && X < 5 && Y < 5 && arr[X][Y] >= 0 && !visited[X][Y] ) {
				dfs(visited, depth+1, X, Y, apple);
				if( flag ) return;
			}
		}
		
		visited[x][y] = false;
	}

}
