import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static int M, N, K;
	public static int[][] arr;
	
	public static int[] X = {-1, 1, 0, 0};
	public static int[] Y = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=0; tc<T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			// 배추 밭 세팅
			arr = new int[M][N];
			for(int i=0; i<K; i++) {
				StringTokenizer cabbage = new StringTokenizer(br.readLine());
				
				int X = Integer.parseInt(cabbage.nextToken());
				int Y = Integer.parseInt(cabbage.nextToken());
				
				arr[X][Y] = 1;
			}
			
			// 아직 탐색하지 못한 배추모임 dfs로 탐색하며 지렁이 마리 수 구하기
			int cnt = 0;
			for(int i=0; i<M; i++) {
				for(int j=0; j<N; j++) {
					if( arr[i][j] == 1 ) {
						dfs(i, j);
						cnt++;
					}
				}
			}
			sb.append(cnt+"\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void dfs(int x, int y) {
		// 방문 상태로 변경
		arr[x][y] = 2;
		
		for(int i=0; i<4; i++) {
			int a = x + X[i];
			int b = y + Y[i];
			
			if( a >= 0 && a < M && b >= 0 && b < N && arr[a][b] == 1 ) dfs(a, b);
		}
	}

}
