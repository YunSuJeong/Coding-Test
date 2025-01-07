import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=N*2-1; i++) {
			int n = (i%N == 0 ? N : i%N);
			if( i > N ) n = N-i%N;
			for(int j=1; j<=N*2-n; j++) {
				if( j <= n-1 ) sb.append(" ");
				else sb.append("*");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

}