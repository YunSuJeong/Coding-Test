import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		StringTokenizer st = new StringTokenizer(str);
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		for(int i=M; i<=N; i++) {
			boolean isPrime = true;
			if(i == 1) continue;
			if(i == 2) {
				System.out.println(2);
				continue;
			}
			for(int j=2; j*j<=i; j++) {
				if( i % j == 0 ) {
					isPrime = false;
					break;
				}
			}
			if(isPrime) System.out.println(i);
		}
	}

}
