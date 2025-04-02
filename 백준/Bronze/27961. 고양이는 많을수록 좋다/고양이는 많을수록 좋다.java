import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long N = Long.parseLong(br.readLine());
		
		long num = 2, pow = 1;
		while( true ) {
			if( N <= num ) break;
			
			pow++;
			num *= 2;
		}
		System.out.println(N < 2 ? N : pow + 1);
	}

}
