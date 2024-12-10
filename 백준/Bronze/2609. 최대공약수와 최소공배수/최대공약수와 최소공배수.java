import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*	최대공약수와 최소공배수 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		StringTokenizer st = new StringTokenizer(str);
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int g = gcd(a, b);			// 최대공약수
		int l = a * b / g;			// 최소공배수 = 두 수의 곱 / 최대공약수
		
		System.out.println(g);
		System.out.println(l);
	}
	
	// 최대공약수 구하기 (유클리드 호제법)
	public static int gcd(int a, int b) {
		if( b == 0 ) return a;
		else return gcd(b, a%b);
	}

}
