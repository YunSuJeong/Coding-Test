import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			int d = Integer.parseInt(br.readLine());
			
			int D = 0;
			if( d >= 1000000 ) D = 5;
			else if( d >= 100000 ) D = 4;
			else if( d >= 10000 ) D = 3;
			else if( d >= 1000 ) D = 2;
			else if( d >= 100 ) D = 1;
			
			System.out.printf("#%d %d\n", tc, D);
		}
	}

}
