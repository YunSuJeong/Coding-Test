import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long N = Long.parseLong(br.readLine());
		long[] factorial = new long[21];
		factorial[0] = 1;
		for(int i=1; i<=20; i++) {
			factorial[i] = factorial[i-1] * i;
		}
		
		boolean flag = true;
		long sum = 0;
		for(int i=0; i<=20; i++) {
			// N보다 큰 최소 팩토리얼 일 때,
			if( N <= factorial[i] ) {
				// 이전 팩토리얼까지 합보다 크고 현재 팩토리얼보다 작으면 불가능
				if( N > sum && N < factorial[i] ) {
					flag = false;
				}
				break;
			}
			sum += factorial[i];
		}
		System.out.println(N == 0 ? "NO" : flag ? "YES" : "NO");
	}

}
