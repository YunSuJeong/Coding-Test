import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringTokenizer T = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(T.nextToken());
		}
		
		long sum = 0, max = 0;
		for(int i=0; i<N; i++) {
			if( i < m ) sum += arr[i];
			else sum = sum - arr[i-m] + arr[i];
			
			max = Math.max(max, sum);
		}
		System.out.println(max);
	}

}
