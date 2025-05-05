import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static int[][] arr = new int[5][5];
	public static boolean[][] bingo = new boolean[5][5];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0; i<5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<5; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for(int i=0; i<5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1; j<=5; j++) {
				int num = Integer.parseInt(st.nextToken());
				
				removeNum(num);
				
				// 가로, 세로, 대각선 빙고 확인
				int cnt = checkBingo();
				
				if( cnt >= 3 ) {
					System.out.println(i*5+j);
					return;
				}
			}
		}
		
	}
	
	public static void removeNum(int n) {
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				if( arr[i][j] == n ) {
					bingo[i][j] = true;
					return;
				}
			}
		}
	}
	
	public static int checkBingo() {
		int count = 0;
		
		// 가로, 세로
		for(int i=0; i<5; i++) {
			int row = 0, col = 0;
			for(int j=0; j<5; j++) {
				if( bingo[i][j] ) row++;
				if( bingo[j][i] ) col++;
			}
			if( row == 5 ) count++;
			if( col == 5 ) count++;
		}
		
		// 대각선
		int x1 = 0, y1 = 0;
		int x2 = 4, y2 = 0;
		int d1 = 0, d2 = 0;
		for(int i=0; i<5; i++) {
			if( bingo[x1][y1] ) d1++;
			x1++; y1++;
			
			if( bingo[x2][y2] ) d2++;
			x2--; y2++;
		}
		if( d1 == 5 ) count++;
		if( d2 == 5 ) count++;
		return count;
	}

}
