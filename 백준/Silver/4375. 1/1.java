import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String n = "";
		
		while( (n=br.readLine()) != null ) {
			int num = Integer.parseInt(n);
            // n의 최댓값의 배수는 long형보다도 크므로 BigInteger클래스 사용
			BigInteger m = new BigInteger("1");
			
			while( num % 2 != 0 && num % 5 != 0 ) {
				if( m.remainder(BigInteger.valueOf(num)) == BigInteger.valueOf(0) ) break;
				m = m.multiply(BigInteger.valueOf(10)).add(BigInteger.valueOf(1));
			}
			System.out.println(m.toString().length());
		}
	}

}
