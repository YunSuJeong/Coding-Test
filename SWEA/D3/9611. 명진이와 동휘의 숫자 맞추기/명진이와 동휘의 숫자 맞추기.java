import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			int[] arr = new int[10];
			for(int i=0; i<N; i++) {
				String str = br.readLine();
				String yn = str.split(" ")[4];
				
				for(int j=0; j<4; j++) {
					int n = Integer.parseInt(str.split(" ")[j]);
					if( yn.equals("YES") ) {
						arr[n]++;
					} else {
						arr[n]--;
					}
				}
			}
			
			int max = 0;
			for(int i=0; i<10; i++) {
				if( arr[i] > arr[max]  ) {
					max = i;
				}
			}
			System.out.printf("#%d %d\n", tc, max);
		}
	}

}
