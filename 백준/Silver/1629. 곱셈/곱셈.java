import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static long A, B, C, result = 1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Long.parseLong(st.nextToken());
		B = Long.parseLong(st.nextToken());
		C = Long.parseLong(st.nextToken());
		
		long result = multi(B);
		
		System.out.println(result);
	}

	public static long multi(long b) {
		if( b == 0 ) return result;

		if( b % 2 == 1 ) {
			result = (result * A) % C; 
		}
		A = (A * A) % C;
		
		return multi(b/2);
	}
}
