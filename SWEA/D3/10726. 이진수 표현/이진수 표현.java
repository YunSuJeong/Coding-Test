import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			boolean flag = true;
			for(int i=0; i<N; i++) {
				if( M % 2 == 1 ) {
					M /= 2;
				} else {
					flag = false;
					break;
				}
			}
			System.out.printf("#%d %s\n", tc, flag ? "ON" : "OFF");
		}
	}

}
