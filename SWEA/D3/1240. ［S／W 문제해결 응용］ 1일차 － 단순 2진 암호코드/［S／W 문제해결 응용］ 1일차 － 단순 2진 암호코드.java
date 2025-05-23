import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("0001101", 0);
		map.put("0011001", 1);
		map.put("0010011", 2);
		map.put("0111101", 3);
		map.put("0100011", 4);
		map.put("0110001", 5);
		map.put("0101111", 6);
		map.put("0111011", 7);
		map.put("0110111", 8);
		map.put("0001011", 9);
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			char[][] arr = new char[N][M];
			for(int i=0; i<N; i++) {
				String str = br.readLine();
				for(int j=0; j<M; j++) {
					arr[i][j] = str.charAt(j);
				}
			}
			
			// 1이 처음 등장한 위치 찾기
			int r = -1, c = -1;
			for(int i=0; i<N; i++) {
				for(int j=M-1; j>=0; j--) {
					if( arr[i][j] == '1' ) {
						r = i;
						c = j;
						break;
					}
				}
				if( r > 0 && c > 0 ) break;
			}
			
			int cnt = 8, even = 0, odd = 0;
			for(int i=c; i>=0; i-=7) {
				for(int j=6; j>=0; j--) {
					sb.append(arr[r][i-j]);
				}
				int num = map.get(sb.toString());
				
				if( cnt % 2 == 0 ) even += num;
				else odd += num;
				sb.setLength(0);
				cnt--;
				
				if( cnt == 0 ) break;
			}
			
			boolean flag = false;
			if( (odd * 3 + even) % 10 == 0 ) flag = true;
			
			System.out.printf("#%d %d\n", tc, flag ? even+odd : 0);
		}
	}

}
