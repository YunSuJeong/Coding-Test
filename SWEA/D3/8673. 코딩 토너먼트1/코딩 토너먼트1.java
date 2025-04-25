import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			int K = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int person = (int) Math.pow(2, K);
			int[] arr = new int[person];
			for(int i=0; i<person; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int sum = 0;
			for(int i=K-1; i>=0; i--) {
				for(int j=0; j<person; j+=Math.pow(2, K-i)) {
					int p = (int) Math.pow(2, K-1-i);
					sum += Math.abs(arr[j] - arr[j+p]);
					if( arr[j] < arr[j+p] ) {
						arr[j] = arr[j+p];
					}
				}
			}
			System.out.printf("#%d %d\n", tc, sum);
		}
	}

}
