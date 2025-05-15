import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1; tc<=10; tc++) {
			int dump = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int[] arr = new int[101];
			int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
			for(int i=1; i<=100; i++) {
				int num = Integer.parseInt(st.nextToken());
				arr[num]++;
				max = Math.max(max, num);
				min = Math.min(min, num);
			}
			
			for(int i=0; i<dump; i++) {
				arr[max]--;
				arr[min]--;
				
				arr[max-1]++;
				arr[min+1]++;
				
				if( arr[max] == 0 ) {
					while( true ) {
						if( arr[max] > 0 ) break;
						max--;
					}
				} 
				if( arr[min] == 0 ) {
					while( true ) {
						if( arr[min] > 0 ) break;
						min++;
					}
				}
			}
			System.out.printf("#%d %d\n", tc, max-min);
		}
		
	}

}
