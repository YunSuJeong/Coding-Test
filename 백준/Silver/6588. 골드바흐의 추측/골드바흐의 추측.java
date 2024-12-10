import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		
		// 1. 1,000,000이하의 소수 모두 구하기
		boolean prime[] = new boolean[1000001];
		for(int i=2; i*i<1000001; i++) {
			if( !prime[i] ) {
				for(int j=i*i; j<=1000000; j+=i) {
					prime[j] = true;
				}
			}
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str = "";
		while( (str=br.readLine()) != null ) {
			int n = Integer.parseInt(str);
			
			if( n == 0 ) break;
			
			int a = 0, b = 0;
			// 2. n부터 b-a가 가장 큰 두 소수의 합을 구하기
			for(int i=3; i<=n/2; i+=2) {
				if( prime[i] == false && prime[n-i] == false ) {
					a = i;
					b = n-i;
					sb.append(String.format("%d = %d + %d\n", n, i, n-i));
					break;
				} 
			}
			if( a == 0 && b == 0 ) sb.append("Goldbach's conjecture is wrong.\n");
		}
		
		System.out.print(sb.toString());
	}

}
