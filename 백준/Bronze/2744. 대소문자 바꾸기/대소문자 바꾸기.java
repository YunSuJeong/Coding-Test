import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String word = br.readLine();
		
		// A = 65, a = 97
		for(int i=0; i<word.length(); i++) {
			if( word.charAt(i) >= 65 && word.charAt(i) <= 91 )
				System.out.printf("%c", word.charAt(i)+32);
			else
				System.out.printf("%c", word.charAt(i)-32);
		}
	}

}
