import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			int N = Integer.parseInt(br.readLine());
			
			long arr[] = new long[N+1];
			for(int j=1; j<=N; j++) {
				if( j <= 3 ) arr[j] = 1;
				else if( j <= 5 ) arr[j] = 2;
				else arr[j] = arr[j-5] + arr[j-1];
			}
			sb.append(arr[N]+"\n");
		}
		System.out.println(sb.toString());
	}

}
