import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			char[][] arr = new char[5][15];
			
			for(int i=0; i<5; i++) {
				String str = br.readLine();
				for(int j=0; j<str.length(); j++) {
					arr[i][j] = str.charAt(j);
				}
			}

			for(int i=0; i<15; i++) {
				for(int j=0; j<5; j++) {
					if( arr[j][i] != '\0' ) {		// 비어있는 셀은 제외
						sb.append(arr[j][i]);
					}
				}
			}
			System.out.printf("#%d %s\n", tc, sb.toString());
			sb.setLength(0);
		}
	}

}
