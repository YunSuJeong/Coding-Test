import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			String card = br.readLine();
			String color = br.readLine();
			
			int[][] arr = new int[3][9];
			for(int i=0; i<9; i++) {
				int num = card.charAt(i) - '0' - 1;
				char c = color.charAt(i);
				
				if( c == 'R' ) {
					arr[0][num]++;
				} else if( c == 'G' ) {
					arr[1][num]++;
				} else {
					arr[2][num]++;
				}
			}
			
			int cnt = 0;
			// 색과 3개 숫자가 모두 연속된 경우
			for(int i=0; i<3; i++) {
				for(int j=0; j<7; ) {
					if( arr[i][j] > 0 && arr[i][j+1] > 0 && arr[i][j+2] > 0 ) {
						arr[i][j]--;
						arr[i][j+1]--;
						arr[i][j+2]--;
						cnt++;
					} else {
						j++;
					}
				}
			}	

			// 색과 숫자가 모두 같은 경우
			for(int i=0; i<3; i++) {
				for(int j=0; j<9; j++) {
					if( arr[i][j] >= 3 ) {
						cnt++;
						arr[i][j] -= 3;
					}
				}
			}
			
			System.out.printf("#%d %s\n", tc, cnt == 3 ? "Win" : "Continue");
		}
	}

}
