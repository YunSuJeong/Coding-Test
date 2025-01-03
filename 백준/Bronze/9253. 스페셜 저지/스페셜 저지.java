import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String A = br.readLine();
		String B = br.readLine();
		String str = br.readLine();
		
		
		if( A.indexOf(str) >= 0 && B.indexOf(str) >= 0 ) System.out.println("YES");
		else System.out.println("NO");
		
	}

}
