import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringTokenizer tree = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int arr[] = new int[N];
		int max = 0;
		for(int i=0; i<N; i++) {
			int h = Integer.parseInt(tree.nextToken());;
			arr[i] = h;
			max = Math.max(max, h);
		}
		
		int low = 0, high = max, mid = 0, maxH = 0;
		while( true ) {
			if( low > high ) break;
			
			mid = (low+high)/2;
			
			long H = 0;
			for(int i=0; i<N; i++) {
				if( arr[i] > mid ) H += arr[i] - mid;
			}
			
			if( H >= M ) { 
				low = mid + 1;
				maxH = Math.max(maxH, mid);
			}
			else high = mid - 1;
		}
		System.out.println(maxH);
 	}

}
