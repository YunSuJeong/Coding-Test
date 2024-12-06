import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = "";
		while( (str=br.readLine()) != null ) {
			int n = Integer.parseInt(str);
			
			if( n == 0 ) break;
			
			// 소수 개수 찾기
			int cnt = 0;
			for(int i=n+1; i<=2*n; i++) {
				if( isPrime(i) ) cnt++;
			}
			System.out.println(cnt);
		}

	}
	
	public static boolean isPrime(int num) {
		boolean flag = true;
		
		if( num <= 1 ) flag = false;
		if( num > 2 ) {
			for(int i=2; i*i<=num; i++) {
				if( num % i == 0 ) {
					flag = false;
					break;
				}
			}
		}
		
		return flag;
	}

}
