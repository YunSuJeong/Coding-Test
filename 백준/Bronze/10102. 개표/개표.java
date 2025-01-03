import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int V = Integer.parseInt(br.readLine());
		String str = br.readLine();
		
		int A = 0, B = 0;
		for(int i=0; i<V; i++) {
			if( str.charAt(i) == 'A' ) A++;
			else B++;
		}
		
		if( A == B ) {
			System.out.println("Tie");
		} else if( A > B ) {
			System.out.println("A");
		} else {
			System.out.println("B");
		}
	}

}
