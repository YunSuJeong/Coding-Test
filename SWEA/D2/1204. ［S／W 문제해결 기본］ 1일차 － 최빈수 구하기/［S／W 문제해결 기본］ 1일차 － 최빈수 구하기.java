import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int[] score = new int[101];
			int max = 0;
			for(int i=0; i<1000; i++) {
				int s = Integer.parseInt(st.nextToken());
				score[s]++;
				max = Math.max(max, score[s]);
			}
			
			int cnt = 0;
			for(int i=100; i>=0; i--) {
				if( score[i] == max ) {
					cnt = i;
					break;
				}
			}
			System.out.printf("#%d %d\n", n, cnt);
		}
	}

}
