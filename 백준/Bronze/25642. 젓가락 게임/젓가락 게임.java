import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int round = 1;
		while( A < 5 && B < 5 ) {
			if( round % 2 == 1 ) B += A;
			else A += B;
			round++;
		}
		
		if( A >= 5 ) System.out.println("yj");
		else System.out.println("yt");
	}

}
