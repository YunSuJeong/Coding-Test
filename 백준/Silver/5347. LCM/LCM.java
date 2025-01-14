import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		 int N = Integer.parseInt(br.readLine());
		 
		 for(int i=0; i<N; i++) {
			 String str = br.readLine();
			 StringTokenizer st = new StringTokenizer(str);
			 
			 int a = Integer.parseInt(st.nextToken());
			 int b = Integer.parseInt(st.nextToken());
			 
			 int gcd = gcd(a, b);
			 BigInteger lcm = BigInteger.valueOf((a/gcd)).multiply(BigInteger.valueOf((b/gcd))).multiply(BigInteger.valueOf(gcd));
			 System.out.println(lcm);
		 }
	}
	
	public static int gcd(int a, int b) {
		if( b == 0 ) return a;
		else return gcd(b, a%b);
	}

}
