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
			
			int[] arr = new int[N];
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int max = -1;
			for(int i=0; i<N; i++) {
				for(int j=i+1; j<N; j++) {
					int num = arr[i]*arr[j];
					
					char[] numArr = Integer.toString(num).toCharArray();
					boolean flag = true;
					for(int k=0; k<numArr.length-1; k++) {
						if( numArr[k] > numArr[k+1] ) {
							flag = false;
							break;
						}
					}
					
					if( flag ) max = Math.max(max, num);
				}
			}
			
			System.out.printf("#%d %d\n", tc, max);
		}
	}

}
