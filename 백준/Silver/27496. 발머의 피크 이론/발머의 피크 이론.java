import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringTokenizer a = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(a.nextToken());
		}
		
		int cnt = 0, sum = 0;
		for(int i=0; i<N; i++) {
			if( i < L ) sum += arr[i];
			else sum = sum - arr[i-L] + arr[i];
			if( sum >= 129 && sum <= 138 ) cnt++;
		}
		System.out.println(cnt);
	}

}
