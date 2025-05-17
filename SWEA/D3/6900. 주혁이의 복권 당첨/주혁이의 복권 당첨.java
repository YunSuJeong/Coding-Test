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
			
			String[] arr = new String[N];
			int[] prize = new int[N];
			for(int i=0; i<N; i++) {
				StringTokenizer win = new StringTokenizer(br.readLine());
				
				arr[i] = win.nextToken();
				prize[i] = Integer.parseInt(win.nextToken());
			}
			
			int sum = 0;
			for(int i=0; i<M; i++) {
				String lotto = br.readLine();
				for(int j=0; j<N; j++) {
					boolean flag = true;
					for(int k=0; k<8; k++) {
						if( arr[j].charAt(k) != '*' && arr[j].charAt(k) != lotto.charAt(k) ) {
							flag = false;
							break;
						}
					}
					if( flag ) sum += prize[j];
				}
			}
			System.out.printf("#%d %d\n", tc, sum);
		}
	}

}
