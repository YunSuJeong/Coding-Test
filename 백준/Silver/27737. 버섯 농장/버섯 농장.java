import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static int N, M, K, depth, spore;
	public static int[][] arr;

	public static int[] X = {-1, 1, 0, 0};
	public static int[] Y = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		spore = M;
		
		arr = new int[N][N];
		for(int i=0; i<N; i++) {
			StringTokenizer farm = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(farm.nextToken());
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				// 버섯포자를 심을 수 있는 땅이면서 포자가 남아 있는 경우
				depth = 0;
				if( arr[i][j] == 0 && spore > 0 ) {
					dfs(i, j);					
					spore -= depth % K > 0 ? depth / K + 1: depth / K;		// 인접한 땅의 개수로 심을 최소 포자 개수 구하여 남은 포자 개수 갱신
				}
			}
		}
		
		boolean flag = true;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if( arr[i][j] == 0 ) {
					flag = false;
					break;
				}
			}
			if( !flag ) break;
		}
		if( spore == M ) System.out.println("IMPOSSIBLE");
		else {
			System.out.println(flag && spore >= 0 ? "POSSIBLE" : "IMPOSSIBLE");
			if( flag && spore >= 0 ) System.out.println(spore);
		}
	}
	
	// 현재 위치에서 인접한 땅의 개수 찾기
	public static void dfs(int x, int y) {
		arr[x][y] = 2;			// 버섯이 자란 상태
		depth++;

		for(int i=0; i<4; i++) {
			int a = x + X[i];
			int b = y + Y[i];
			if( a >= 0 && a < N && b >= 0 && b < N && arr[a][b] == 0 ) {
				dfs(a, b);
			}
		}
	}

}
