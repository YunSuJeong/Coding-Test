import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static int R, C;
	public static char[][] arr;
	
	// 상, 좌, 하, 우 순서
	public static int[] X = {-1, 0, 1, 0};
	public static int[] Y = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		if( N == 1 ) {
			System.out.println("*");
		} else {
			R = 4 * N - 1;
			C = 4 * N - 3;
			arr = new char[R][C];
			
			star(R-(N-1)*2-1, C/2, 3, 0);
			
			for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) {
					if( arr[i][j] == '\0' ) sb.append(" ");
					else sb.append(arr[i][j]);
				}
				System.out.println(sb.toString().trim());
				sb.setLength(0);
			}
		}
	}

	// 시작 위치 (x, y), 그려야하는 별의 개수 n, 방향 d
	public static void star(int x, int y, int n, int d) {
		if( x == 0 && y == C - 1 ) return;

		if( x == 0 ) n -= 2;
		
		for(int i=0; i<n; i++) {
			int a = x + i * X[d];
			int b = y + i * Y[d];
			if( a >= 0 && a < R && b >= 0 && b < C ) arr[a][b] = '*';
		}
		
		x = x + (n-1) * X[d];
		y = y + (n-1) * Y[d];
		d = (d + 1) % 4;
		if( d == 0 || d == 2 ) n += 2;
		
		star(x, y, n, d);
	}
}
