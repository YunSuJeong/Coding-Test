import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String K = br.readLine();
		
		int odd = 0, even = 0;
		for(String n : K.split("")) {
			if( Integer.parseInt(n) % 2 == 0 ) even++;
			else odd++;
		}
		
		if( even > odd ) {
			System.out.println(0);
		} else if( odd > even ) {
			System.out.println(1);
		} else {
			System.out.println(-1);
		}
		
	}

}
