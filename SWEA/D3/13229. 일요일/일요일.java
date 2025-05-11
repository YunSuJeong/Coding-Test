import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			String date = br.readLine();
			
			int day = 0;
			switch (date) {
			case "MON":
				day = 6;
				break;
			case "TUE":
				day = 5;
				break;
			case "WED":
				day = 4;
				break;
			case "THU":
				day = 3;
				break;
			case "FRI":
				day = 2;
				break;
			case "SAT":
				day = 1;
				break;
			case "SUN":
				day = 7;
				break;
			}
			System.out.printf("#%d %d\n", tc, day);
		}
	}

}
