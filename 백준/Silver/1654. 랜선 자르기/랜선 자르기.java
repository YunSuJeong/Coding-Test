import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		int max = 0;
		int arr[] = new int[K];
		for(int i=0; i<K; i++) {
			int num = Integer.parseInt(br.readLine());
			arr[i] = num;
			
			if( i == 0 ) max = num;
			else max = Math.max(max, num);
		}
		
		int maxLen = 0;
		long mid = 0, start = 1, end = max;
		while(true) {
			
			if( start > end ) break;
			
			mid = (start+end)/2;
			
			int count = 0;
			for(int a : arr) {
				count += a/mid;
			}

			if(count >= N) maxLen = Math.max(maxLen, (int)mid);
			
			if( count < N ) end = mid-1;
			else start = mid+1;
		}	
		System.out.println(maxLen);
		
	}
	
}
