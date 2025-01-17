import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int first = Integer.parseInt(st.nextToken());
		for(int i=0; i<N-1; i++) {
			int num = Integer.parseInt(st.nextToken());
			int gcd = gcd(first, num);
			System.out.printf("%d/%d\n", first/gcd, num/gcd);
		}
	}
	
	public static int gcd(int a, int b) {
		if( b == 0 ) return a;
		else return gcd(b, a%b);
	}

}
