import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int cnt = 0;
		for(int i=N-2; i>=0; i--) {
			if( arr[i] >= arr[i+1] ) {
				int n = arr[i] - (arr[i+1]-1);
				cnt += n;
				arr[i] -= n;
			}
		}
		System.out.println(cnt);
	}

}
