import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] fib = new int[N+1][2];
		for(int i=2; i<=N; i++) {
			if( i <= 3 ) {
				fib[i][0] = i - 1;
				fib[i][1] = i - 1; 
			} else {
				fib[i][0] = fib[i-2][0] + 1;
				fib[i][1] = Math.max(fib[i-2][1] + 1, fib[i-3][1] + 2);
			}
		}
		
		System.out.printf("%d %d", fib[N][0], fib[N][1]);
	}

}
