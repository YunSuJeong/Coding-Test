import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static int H, W;
	public static String[][] arr;
	public static int[] X = {-1, 1, 0, 0};
	public static int[] Y = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			
			// 그리드 세팅
			arr = new String[H][W];
			for(int i=0; i<H; i++) {
				int idx = 0;
				String str = br.readLine();
				for(String s : str.split("")) {
					arr[i][idx] = s;
					idx++;
				}
			}
			
			int cnt = 0;
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					if( arr[i][j].equals("#") ) {
						dfs(i, j);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
	}
	
	public static void dfs(int x, int y) {
		arr[x][y] = "X";
		
		for(int i=0; i<4; i++) {
			int a = x + X[i];
			int b = y + Y[i];
			if( a >= 0 && a < H && b >=0 && b < W && arr[a][b].equals("#") ) dfs(a, b);
		}
	}

}
