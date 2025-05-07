import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static int[] X = {-1, -2, -2, -1, 1, 2, 2, 1};
	public static int[] Y = {-2, -1, 1, 2, 2, 1, -1, -2};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		boolean[][] chess = new boolean[6][6];

		// 모든 칸 방문 했는지 확인
		int sx = 0, sy = 0;				// 시작점 
		int cnt = 0, c = 0, r = 0;
		int pc = 0, pr = 0;
		for(int i=0; i<36; i++) {
			String str = br.readLine();
			
			c = str.charAt(0) - 65;
			r = str.charAt(1) - 49;

			if( i == 0 ) {
				sx = r;
				sy = c;
			}
			
			if( !chess[r][c] ) {
				chess[r][c] = true;
				cnt++;
			}
			
			// 나이트의 경로인지 체크
			boolean flag = false;
			if( i > 0 ) {
				for(int j=0; j<8; j++) {
					int a = r + X[j];
					int b = c + Y[j];
					
					if( a == pr && b == pc ) {
						flag = true;
						break;
					}
				}
				if( !flag ) {
					cnt = -1;
					break;
				} 
			}
			
			pr = r;
			pc = c; 
		}
		
		// 마지막 위치에서 나이트가 시작점으로 이동 가능한지 체크
		boolean isMove = false;
		for(int i=0; i<8; i++) {
			int a = r + X[i];
			int b = c + Y[i];
			
			if( a == sx && b == sy ) {
				isMove = true;
				break;
			}
		}
		
		System.out.printf(cnt == 36 && isMove ? "Valid" : "Invalid");
	}

}
