import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			int n = Integer.parseInt(br.readLine());
			
			int zero[] = new int[n+1];
			int one[] = new int[n+1];
			
			for(int j=0; j<=n; j++) {
				if( j <= 1 ) {
					zero[j] = 1-j;
					one[j] = j;
				} else {
					zero[j] = zero[j-2] + zero[j-1];
					one[j] = one[j-2] + one[j-1];
				}
			}
			
			System.out.printf("%d %d\n", zero[n], one[n]);
		}
	}

}
