import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str1 = br.readLine();
		String str2 = br.readLine();

		StringTokenizer st1 = new StringTokenizer(str1);
		StringTokenizer st2 = new StringTokenizer(str2);
		
		int a = Integer.parseInt(st1.nextToken());
		int b = Integer.parseInt(st1.nextToken());
		int c = Integer.parseInt(st2.nextToken());
		int d = Integer.parseInt(st2.nextToken());
		
		// 합한 분수의 분자/분모 최대공약수 
		int num = a*d+b*c;
		int denom = b*d;
		int g = gcd(num, denom);
		
		System.out.printf("%d %d", num/g, denom/g);
	}
	
	public static int gcd(int a, int b) {
		if(b == 0) return a;
		else return gcd(b, a%b);
	}

}
