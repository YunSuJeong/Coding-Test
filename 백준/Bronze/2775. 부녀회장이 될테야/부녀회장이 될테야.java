import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			
			System.out.println(recursion(k, n));
		}
	}
	
	public static int recursion(int k, int n) {
		int sum = 0;
		if( k <= 0 ) {
			return n;
		} else {
			for(int i=1; i<=n; i++) {
				sum += recursion(k-1, i);
			}
			return sum;
		}
	}

}
