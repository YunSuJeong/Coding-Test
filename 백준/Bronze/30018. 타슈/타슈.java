import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer A = new StringTokenizer(br.readLine());
		StringTokenizer B = new StringTokenizer(br.readLine());
		
		int min = 0;
		for(int i=0; i<N; i++) {
			int a = Integer.parseInt(A.nextToken());
			int b = Integer.parseInt(B.nextToken());
			
			if( b > a ) min += b - a;
		}
		System.out.println(min);
	}

}
