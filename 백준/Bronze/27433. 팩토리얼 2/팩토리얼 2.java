import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		System.out.println(permutation(N));
	}
	
	public static long permutation(int n) {
		if( n < 2 ) return 1;
		else return n * permutation(n-1);
	}

}
