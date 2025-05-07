import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int[] fib = new int[101];
		fib[1] = 1;
		fib[2] = 1;
		for(int i=3; i<=100; i++) {
			fib[i] = fib[i-1] + fib[i-2];
		}
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			int sum = 0;
			for(int i=1; i<=N; i++) {
				sum += fib[i];
			}
			if( sum % 2 == 0 ) {
				if( N % 3 == 2 ) {
					sb.append("BA");
				} 
				for(int i=0; i<N/3; i++) {
					sb.append("BBA");
				}
				System.out.println(sb.toString());
			} else {
				System.out.println("impossible");
			}
			sb.setLength(0);
		}
	}

}
