import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			int[] arr = new int[N];
			int sum = 0;
			for(int i=0; i<N; i++) {
				int num = Integer.parseInt(br.readLine());
				arr[i] = num;
				sum += num;
			}
			
			int oriSize = sum / N;
			int min = 0;
			for(int i=0; i<N; i++) {
				if( arr[i] > oriSize ) min += arr[i] - oriSize;
			}
			System.out.printf("#%d %d\n", tc, min);
		}
	}

}
