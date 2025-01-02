import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=2*N-1; i++) {
			for(int j=1; j<=N*2; j++) {
				if( i/N <= 0 ) {
					if( j <= i%N || j > N*2-i%N) System.out.print("*");
					else System.out.print(" ");
				} else {
					if( j <= N-i%N || j > N*2-(N-i%N) ) System.out.print("*");
					else System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

}
