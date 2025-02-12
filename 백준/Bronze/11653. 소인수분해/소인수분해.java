import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		if( N > 1 ) {
			int i = 2;
			while( N > 1 ) {
				if( N % i == 0 ) {
					N /= i;
					System.out.println(i);
				} else {
					i++;
				}
			}
		}
	}

}
