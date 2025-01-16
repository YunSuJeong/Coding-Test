import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringTokenizer stN = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int arr[] = new int[N];
		int max = 0;
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(stN.nextToken());
			arr[i] = num;
			max = Math.max(max, num);
		}
		
		int mid = 0, low = 1, high = max, maxLen = 0;
		while(true) {
			if( low > high ) {
				break;
			}

			mid = (low+high)/2;
			

			int cnt = 0;
			for( int a : arr ) {
				cnt += a/mid;
			}
			if( cnt < M ) high = mid - 1;
			else {
				low = mid + 1;
				maxLen = Math.max(maxLen, mid);
			}
		}
		System.out.println(maxLen);
	}

}
