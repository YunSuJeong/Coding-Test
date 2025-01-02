import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		// WelcomeToSMUPC = 14자
		String str = "WelcomeToSMUPC";
		System.out.printf("%c", N%14 == 0 ? str.charAt(13) : str.charAt(N%14-1) );
	}

}
