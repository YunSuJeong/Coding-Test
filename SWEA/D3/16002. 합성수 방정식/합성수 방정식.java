import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			int x = 0, y = 0;
			if( N == 1 ) {
				x = 9;
				y = 8;
			} else {
				x = N * 3;
				y = N * 2;
			}
			sb.append("#"+tc+" "+x+" "+y+"\n");
		}
		System.out.println(sb.toString());
	}

}
