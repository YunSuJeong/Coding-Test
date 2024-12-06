import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long a = sc.nextLong();
		long b = sc.nextLong();
		
		// 최대공약수 구하기
		long g = gcd(a,b);
		
		// 최소공배수 구하기
		System.out.println(a*b/g);
	}
	
	public static long gcd(long a, long b) {
		long gcd = 0;
		if( b == 0 ) gcd = a;
		else gcd = gcd(b, a%b);
		return gcd; 
	}

}
