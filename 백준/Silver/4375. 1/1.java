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
			// 2) 나머지 연산 활용
			int len = 1;
			int multi = 1 % num;
			while( true ) {
				if( multi % num == 0 ) break;
				multi = (multi * 10 + 1) % num;
				len++;
			}
			System.out.println(len);
		}
	}

}
