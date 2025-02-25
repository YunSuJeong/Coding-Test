import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Point{
	int x;
	int y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class Solution {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		// 좌표에 할당된 값 구해놓기
		Map<Integer, Point> map = new HashMap<Integer, Point>();
		int[][] arr = new int[300][300];
		for(int i=1; i<300; i++) {
			for(int j=1; j<300; j++) {
				if( i == 1 ) {
					if( j == 1 ) {
						arr[i][j] = 1;
					} else {
						arr[i][j] = arr[i][j-1] + j - 1;
					}
				} else {
					arr[i][j] = arr[i-1][j] + i + j - 1;
				}
				map.put(arr[i][j], new Point(i, j));
			}
		}
        
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			
			// 별 연산
			int px = map.get(p).x + map.get(q).x;
			int py = map.get(p).y + map.get(q).y;
			System.out.printf("#%d %d\n", tc, arr[px][py]);
		}
	}

}
