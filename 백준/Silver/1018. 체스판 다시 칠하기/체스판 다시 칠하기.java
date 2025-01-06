import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str1 = br.readLine();
		
		StringTokenizer st = new StringTokenizer(str1);
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		char arr[][] = new char[N][M];
		for(int i=0; i<N; i++) {
			String str2 = br.readLine();
			for(int j=0; j<M; j++) {
				arr[i][j] = str2.charAt(j);
			}
		}
		
		// 1) 8*8 체스판 선택
		int min = 32;
		for(int n=0; n<N-7; n++) {
			for(int m=0; m<M-7; m++) {
				// black = 가장 왼쪽 위칸이 검정색일 때, 변경해야하는 정사각형 개수
				// white = 가장 왼쪽 위칸이 흰색일 때, 변경해야하는 정사각형 개수
				int black = 0, white = 0, cnt;
				for(int i=n; i<8+n; i++) {
					for(int j=m; j<8+m; j++) {
						if( (i % 2 == 0 && j % 2 == 0) || (i % 2 == 1 && j % 2 == 1) ) {
							if( arr[i][j] != 'B' ) black++;
							else white++;
						} else {
							if( arr[i][j] != 'W' ) black++;
							else white++;
						}
					}
				}
				cnt = black;
				if( white < black ) cnt = white;
				min = Math.min(min, cnt);
			}
		}
		
		System.out.println(min);
	}

}


