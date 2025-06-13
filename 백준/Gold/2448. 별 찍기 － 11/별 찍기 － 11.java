import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static int N;
	public static char[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		arr = new char[N][N*2];
		
		triangle(0, N, N);
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N*2; j++) {
				if( arr[i][j] == '\0' ) sb.append(" ");
				else sb.append(arr[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void triangle(int x, int y, int n) {
		if( x < 0 || x >= N || y < 0 || y >= N*2 ) return;
		
		// 삼각형 그리기
		arr[x][y-1] = '*';
		
		arr[x+1][y-2] = '*';
		arr[x+1][y] = '*';
		
		for(int i=y-3; i<=y+1; i++) {
			arr[x+2][i] = '*';
		}
		
		if( n / 2 >= 3 ) {
			// 현재 삼각형
			triangle(x, y, n/2);
			
			// 왼쪽 삼각형
			triangle(x+n/2, y-n/2, n/2);
			
			// 오른쪽 삼각형
			triangle(x+n/2, y+n/2, n/2);
		}
		
	}

}
