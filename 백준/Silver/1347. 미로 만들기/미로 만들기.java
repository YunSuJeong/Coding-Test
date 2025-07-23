import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	// 방향전환을 위한 배열
	public static int[] X = {1, 0, -1, 0};
	public static int[] Y = {0, -1, 0, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int len = Integer.parseInt(br.readLine());
		String cmd = br.readLine();
		
		int x = 0, y = 0, d = 0;
		int minX = 0, minY = 0, maxX = 0, maxY = 0;
		for(int i=0; i<len; i++) {
			char c = cmd.charAt(i);
			
			if( c == 'L' ) {
				d = (3 + d) % 4;
			} else if( c == 'R' ) {
				d = (d + 1) % 4;
			} else {
				// 한 칸 이동
				x += X[d];
				y += Y[d];
			}
			
			minX = Math.min(minX, x);
			maxX = Math.max(maxX, x);
			minY = Math.min(minY, y);
			maxY = Math.max(maxY, y);
		}
		
		int r = maxX - minX + 1;
		int c = maxY - minY + 1;
		char[][] arr = new char[r][c];
		 
		boolean flag = true;
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				for(char[] a : arr) Arrays.fill(a, '#');

				d = 0;
				x = i; y = j;		// 시작 위치
				arr[i][j] = '.';
				flag = true;		// 모두 탐색했는지 탐색용 플래그

				for(int k=0; k<len; k++) {
					if( cmd.charAt(k) == 'L' ) {
						d = (3 + d) % 4;
					} else if( cmd.charAt(k) == 'R' ) {
						d = (d + 1) % 4;
					} else {
						// 한 칸 이동
						x += X[d];
						y += Y[d];
						
						if( x < 0 || y < 0 || x >= r || y >= c ) {
							flag = false;
							break;
						} 
						
						arr[x][y] = '.';
					}
				}
				
				if( flag ) break;
			}
			if( flag ) break;
		}
		
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}

}
