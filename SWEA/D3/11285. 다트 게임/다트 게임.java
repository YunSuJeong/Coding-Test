import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			long sum = 0;
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				int dist = x * x + y * y;
				
				int score;
				if( dist > 40000 ) {
					score = 0;
				} else if( dist > 32400 ) {
					score = 1;
				} else if( dist > 25600 ) {
					score = 2;
				} else if( dist > 19600 ) {
					score = 3;
				} else if( dist > 14400 ) {
					score = 4;
				} else if( dist > 10000 ) {
					score = 5;
				} else if( dist > 6400 ) {
					score = 6;
				} else if( dist > 3600 ) {
					score = 7;
				} else if( dist > 1600 ) {
					score = 8;
				} else if( dist > 400 ) {
					score = 9;
				} else {
					score = 10;
				}
				
				sum += score;
			}
			System.out.printf("#%d %d\n", tc, sum);
		}
	}

}
