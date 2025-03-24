import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static int w, h;
	public static int[][] arr;
	
	// 인접한 8개 정사각형 위치
	public static int[] X = {-1, -1, -1, 0, 1, 1, 1, 0};
	public static int[] Y = {-1, 0, 1, 1, 1, 0, -1, -1};
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str = "";
		
		while( (str = br.readLine()) != null ) {
			StringTokenizer st = new StringTokenizer(str);
			
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			if( w == 0 && h == 0 ) break;
			
			// 지도 세팅
			arr = new int[h][w];
			for(int i=0; i<h; i++) {
				StringTokenizer map = new StringTokenizer(br.readLine());
				for(int j=0; j<w; j++) {
					arr[i][j] = Integer.parseInt(map.nextToken());
				}
			}
			
			int count = 0;
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					// 아직 탐색되지 않은 땅일 때, dfs로 섬인지 탐색
					if( arr[i][j] == 1 ) {
						 dfs(i, j);
						 count++;
					}
				}
			}
			sb.append(count+"\n");
		}
		
		System.out.println(sb.toString());
	}
	
	// 이 섬의 땅이 어디까지인지 dfs로 탐색
	public static void dfs(int x, int y) {
		arr[x][y] = 2;			// 방문 체크
		
		for(int i=0; i<8; i++) {
			int a = x + X[i];
			int b = y + Y[i];
			if( a >= 0 && a < h && b >=0 && b < w && arr[a][b] == 1 ) 
				dfs(a, b);
		}
	}

}
