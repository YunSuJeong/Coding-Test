import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			int angle = Integer.parseInt(br.readLine());
			
			angle *= 2;
			
			int h = angle / 60;
			int m = angle - h * 60;
			
			System.out.printf("#%d %d %d\n", tc, h, m);
		}
	}

}
