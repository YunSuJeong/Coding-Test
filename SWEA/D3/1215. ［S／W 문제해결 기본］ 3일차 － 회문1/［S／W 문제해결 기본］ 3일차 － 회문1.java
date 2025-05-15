import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1; tc<=10; tc++) {
			int len = Integer.parseInt(br.readLine());

			char[][] arr = new char[8][8];
			for(int i=0; i<8; i++) {
				String str = br.readLine();
				for(int j=0; j<8; j++) {
					arr[i][j] = str.charAt(j);
				}
			}
			
			int cnt = 0;
			for(int i=0; i<8; i++) {
				for(int j=0; j<8-len+1; j++) {
					boolean flag1 = true, flag2 = true;
					for(int k=0; k<len/2; k++) {
						if( arr[i][j+k] != arr[i][j+len-k-1] ) {
							flag1 = false;
							break;
						}
					}
					for(int k=0; k<len/2; k++) {
						if( arr[j+k][i] != arr[j+len-k-1][i] ) {
							flag2 = false;
							break;
						}
					}
					if( flag1 ) cnt++;
					if( flag2 ) cnt++;
				}
			}
			
			System.out.printf("#%d %d\n", tc, cnt);
		}
	}

}
