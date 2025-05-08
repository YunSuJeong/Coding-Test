import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		long maxA = 0, maxB = 0;
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			long a = Long.parseLong(st.nextToken());
			long b = Long.parseLong(st.nextToken());
			
			if( a < b ) {
				maxA = Math.max(maxA, a);
				maxB = Math.max(maxB, b);
			} else {
				maxA = Math.max(maxA, b);
				maxB = Math.max(maxB, a);
			}
		}
		System.out.println(maxA*maxB);
	}

}
