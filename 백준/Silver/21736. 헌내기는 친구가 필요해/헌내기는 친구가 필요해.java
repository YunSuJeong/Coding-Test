import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static int N, M, cnt = 0;
	public static char[][] arr;
	
	public static int[] X = {-1, 1, 0, 0};
	public static int[] Y = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 캠퍼스 및 도연이 위치 세팅
		arr = new char[N][M];
		int x = 0, y = 0;
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				arr[i][j] = str.charAt(j);
				if( arr[i][j] == 'I' ) {
					x = i;
					y = j;
				}
			}
		}
		
		// dfs로 만날 수 있는 사람 수 탐색
		dfs(x, y);
		
		if( cnt == 0 ) System.out.println("TT");
		else System.out.println(cnt);
	}
	
	public static void dfs(int x, int y) {
		if( arr[x][y] == 'P' ) cnt++;
		
		arr[x][y] = 'X';			// 방문 처리
		
		// 벽, 밖이 아니면 이동
		for(int i=0; i<4; i++) {
			int a = x + X[i];
			int b = y + Y[i];
			
			if( a >=0 && a < N && b >= 0 && b < M && arr[a][b] != 'X' ) 
				dfs(a, b);
		}
	}
}
