import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	
	public static char[][] arr = new char[8][8];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		arr = new char[8][8];
		for(int tc=1; tc<=10; tc++) {
			int l = Integer.parseInt(br.readLine());
			
			for(int i=0; i<8; i++) {
				String str = br.readLine();
				for(int j=0; j<8; j++) {
					arr[i][j] = str.charAt(j);
				}
			}
			
			int count = 0;
			for(int i=0; i<8; i++) {
				for(int j=0; j<=8-l; j++) {
					count += isPalin(l, i, j);
				}
			}
			
			System.out.printf("#%d %d\n", tc, count);
		}
	}

	public static int isPalin(int l, int n, int m) {
		int count = 0;
		
		boolean w = true, h = true;
		for(int i=0; i<l/2; i++) {
			if( arr[n][m+i] != arr[n][m+l-i-1] ) {
				w = false;
				break;
			}
		}
		
		for(int i=0; i<l/2; i++) {
			if( arr[m+i][n] != arr[m+l-i-1][n] ) {
				h = false;
				break;
			}
		}
		
		if( w ) count++;
		if( h ) count++;
		return count;
	}
}
