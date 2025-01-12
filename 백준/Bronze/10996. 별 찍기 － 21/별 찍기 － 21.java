import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=N*2; i++) {
			if( N % 2 == 0 ) {
				if( i % 2 == 0 ) {
					for(int j=1; j<=N; j++) {
						if( j % 2 == 0 ) sb.append("*");
						else sb.append(" ");
					}
				} else {
					for(int j=1; j<=N-1; j++) {
						if( j % 2 == 0 ) sb.append(" ");
						else sb.append("*");
					}
				}
			} else {
				if( i % 2 == 0 ) {
					for(int j=1; j<=N-1; j++) {
						if( j % 2 == 0 ) sb.append("*");
						else sb.append(" ");
					}
				} else {
					for(int j=1; j<=N; j++) {
						if( j % 2 == 0 ) sb.append(" ");
						else sb.append("*");
					}
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
