import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		long N = Long.parseLong(br.readLine());
		
		if( N == 0 ) System.out.println(0);
		while( N != 0 ) {
			if( N == -1 ) {
				sb.insert(0, 11);
				break;
			}
			long remain = N % -2;
			if( remain < 0 ) {
				sb.insert(0, remain+2);
				N = N/-2+1;
			} else {
				sb.insert(0, remain);
				N = N/-2;
			}
			
		}
		System.out.println(sb.toString());
	}

}
