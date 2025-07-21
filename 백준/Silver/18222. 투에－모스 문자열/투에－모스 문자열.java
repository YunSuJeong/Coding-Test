import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static int flip = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long k = Long.parseLong(br.readLine());
		
		long n = 1;
		while(n < k) {
			n *= 2;
		}
		
		thueMorse(n, k);
		
		// 뒤집힌 횟수가 짝수면 0, 홀수면 1
		System.out.println(flip % 2 == 0 ? 0 : 1);
	}
	
	public static void thueMorse(long n, long i) {
		if( n == 1 ) return;
		
		// k번째 문자가 오른쪽 절반에 위치할때만 위치 재설정, 뒤집기 횟수 증가
		if( n / 2 < i ) {
			i -= n / 2;
			flip++;
		}
		
		thueMorse(n/2, i);
	}

}
