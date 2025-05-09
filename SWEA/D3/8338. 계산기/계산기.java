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
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int max = 0;
			for(int i=0; i<N; i++) {
				int num = Integer.parseInt(st.nextToken());
				
				max = Math.max(max + num, max * num);
			}
			System.out.printf("#%d %d\n", tc, max);
		}
	}

}
