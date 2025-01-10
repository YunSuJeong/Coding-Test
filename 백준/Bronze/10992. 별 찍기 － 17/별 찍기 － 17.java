import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N+(i-1); j++) {
				if( i < N ) {
					if( j <= N-i ) sb.append(" ");
					else if( j == N-(i-1) ) sb.append("*");
					else if( j < N+(i-1) ) sb.append(" ");
					else if( j == N+(i-1) ) sb.append("*");
				} else {
					sb.append("*");
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
