import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int arr[] = new int[N+1];
		
		for(int i=0; i<=N; i++) {
			if( i <= 1 ) arr[i] = i;
			else arr[i] = arr[i-2] + arr[i-1];
		}
		
		System.out.println(arr[N]);
	}

}
