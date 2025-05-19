import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			String str = br.readLine();
			int len = str.length();
			
			String strL = str.replace('?', 'L');
			String strR = str.replace('?', 'R');
			
			int maxL = Integer.MIN_VALUE, maxR = Integer.MIN_VALUE;
			int distL = 0, distR = 0;
			for(int i=0; i<len; i++) {
				distL += strL.charAt(i) == 'L' ? -1 : 1;
				maxL = Math.max(maxL, Math.abs(distL));
			}

			for(int i=0; i<len; i++) {
				distR += strR.charAt(i) == 'L' ? -1 : 1;
				maxR = Math.max(maxR, Math.abs(distR));
			}
			System.out.printf("%d\n", Math.max(maxL, maxR));
		}
	}

}
