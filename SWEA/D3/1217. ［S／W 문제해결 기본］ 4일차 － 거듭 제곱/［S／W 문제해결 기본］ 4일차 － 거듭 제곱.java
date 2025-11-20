import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc=1; tc<=10; tc++) {
			int t = sc.nextInt();
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			System.out.printf("#%d %d\n", t, pow(n, m));
		}
	}
	
	public static int pow(int n, int m) {
		int result = 1;
		while( m > 0 ) {
			if( m % 2 == 0 ) {
				m /= 2;
				n *= n;
			} else {
				m--;
				result *= n;
			}
		}
		return result;
	}

}
