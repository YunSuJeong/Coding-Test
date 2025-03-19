import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	
	public static int N;
	public static boolean flag = false;
	public static String[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			
			// 오목 맵 세팅
			arr = new String[N][N];
			for(int i=0; i<N; i++) {
				String str = br.readLine();
				int j = 0;
				for(String s : str.split("")) {
					arr[i][j] = s;
					j++;
				}
			}
			
			// 판정
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if( !flag && arr[i][j].equals("o") ) {
						if( !flag ) row(i, j);				// 가로
						if( !flag ) col(i, j);				// 세로
						if( !flag ) diagonal(i, j);			// 대각선
					}
				}
			}
			
			System.out.printf("#%d %s\n", tc, flag ? "YES" : "NO");
			flag = false;
		}
		
	}
	
	public static void row(int x, int y) {
		int len = y + 4 >= N ? N-1 : y+4;
		int cnt = 0;
		for(int i=y; i<=len; i++) {
			if( arr[x][i].equals("o") ) cnt++;
			else break;
		}
		
		if( cnt == 5 ) flag = true;
	}
	
	public static void col(int x, int y) {
		int len = x + 4 >= N ? N-1 : x+4;
		int cnt = 0;
		for(int i=x; i<=len; i++) {
			if( arr[i][y].equals("o") ) cnt++;
			else break;
		}
		
		if( cnt == 5 ) flag = true;
	}

	public static void diagonal(int x, int y) {
		// 왼쪽 아래 방향
		int cnt = 0;
		for(int i=0; i<=4; i++) {
			int a = x + i;
			int b = y - i;
			if( a < N && b >= 0 && arr[a][b].equals("o") ) cnt++;
			else break;
		}
		if( cnt == 5 ) flag = true;
		
		// 오른쪽  아래 방향
		cnt = 0;
		for(int i=0; i<=4; i++) {
			int a = x + i;
			int b = y + i;
			if( a < N && b < N && arr[a][b].equals("o") ) cnt++;
			else break;
		}
		if( cnt == 5 ) flag = true;
	}
}
