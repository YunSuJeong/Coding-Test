import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			
			char[][] arr = new char[8][8];
			int rook = 0;
			
			for(int i=0; i<8; i++) {
				String str = br.readLine();
				for(int j=0; j<8; j++) {
					arr[i][j] = str.charAt(j);
					if( arr[i][j] == 'O' ) rook++;
				}
			}
			
			boolean isAttack = false;
			if( rook == 8 ) {
				for(int i=0; i<8; i++) {
					int row = 0, col = 0;
					for(int j=0; j<8; j++) {
						if( arr[i][j] == 'O' ) row++;
						if( arr[j][i] == 'O' ) col++;
					}
					if( row > 1 || col > 1 ) {
						isAttack = true;
						break;
					}
				}
			}
			
			String result = "no";
			if( rook == 8 && !isAttack ) result = "yes";
			System.out.printf("#%d %s\n", tc, result);
		}
	}

}
