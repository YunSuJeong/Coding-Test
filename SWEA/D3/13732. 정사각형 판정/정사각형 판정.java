import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			char[][] arr = new char[N][N];
			// 막힌 부분 좌표 최대/최소값
			int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE, maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;
			
			for(int i=0; i<N; i++) {
				String str = br.readLine();
				for(int j=0; j<N; j++) {
					char c = str.charAt(j);
					
					arr[i][j] = c;
					if( c == '#' ) {
						minX = Math.min(minX, i);
						minY = Math.min(minY, j);
						maxX = Math.max(maxX, i);
						maxY = Math.max(maxY, j);
					}
				}
			}
			
			String result = "no";
			if( maxX - minX == maxY - minY ) {
				boolean flag = true;
				for(int i=0; i<N; i++) {
					for(int j=0; j<N; j++) {
						if( i >= minX && i <= maxX && j >= minY && j <= maxY ) {
							// 정사각형 범위 내에서 '#'가 아니면 정사각형 자격 박탈
							if( arr[i][j] != '#' ) {
								flag = false;
								break;
							}
						} else {
							// 범위 밖에서 '#'이 존재하면 정사각형 자격 박탈
							if( arr[i][j] == '#' ) {
								flag = false;
								break;
							}
						}
					}
					if( !flag ) break;
				}
				if( flag ) result = "yes";
			}
			
			System.out.printf("#%d %s\n", tc, result);
		}
	}

}
