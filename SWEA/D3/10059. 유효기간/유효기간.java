import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			String str = br.readLine();
			
			int aa = Integer.parseInt(str.substring(0, 2));
			int bb = Integer.parseInt(str.substring(2));
			
			String result = "NA";
			if( aa > 0 && aa <= 12 && bb > 0 && bb <= 12 ) {
				result = "AMBIGUOUS";
			} else if( aa > 0 && aa <= 12 && (bb > 12 || bb == 0) ) {
				result = "MMYY";
			} else if( (aa > 12 || aa == 0) && bb > 0 && bb <= 12 ) {
				result = "YYMM";
			}
			
			System.out.printf("#%d %s\n", tc, result);
		}
		
	}

}
