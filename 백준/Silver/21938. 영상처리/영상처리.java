import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static int N, M, cnt = 0;
	public static int[][] arr;
	public static int[] X = {-1, 1, 0, 0};
	public static int[] Y = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		
		for(int i=0; i<N; i++) {
			StringTokenizer rgb = new StringTokenizer(br.readLine());
			
			for(int j=0; j<M; j++) {
				int R = Integer.parseInt(rgb.nextToken());
				int G = Integer.parseInt(rgb.nextToken());
				int B = Integer.parseInt(rgb.nextToken());
				
				arr[i][j] = R + G + B;
			}
		}
		
		// 경계값과 비교하여 새로운 화면으로 만들기
		int T = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if( arr[i][j] >= T*3 ) arr[i][j] = 255;
				else arr[i][j] = 0;
			}
 		}
		
		// dfs로 물체 개수 찾기
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if( arr[i][j] > 0 ) {
					dfs(i, j);
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
 	}

	// 더 이상 인접한 픽셀이 없을 때까지 탐색 후 리턴되어야 하기때문에, 명시적인 리턴은 없다.
	public static void dfs(int x, int y) {
		arr[x][y] = -1;		// 방문여부
		
		for(int i=0; i<4; i++) {
			int a = x + X[i];
			int b = y + Y[i];
			
			if( a >= 0 && b >=0 && a < N && b < M && arr[a][b] > 0 ) 
				dfs(a, b);
		}
	}

}
