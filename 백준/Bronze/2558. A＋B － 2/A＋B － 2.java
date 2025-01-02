import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = "";
		int sum = 0;
		while( (str=br.readLine()) != null ) {
			
			if( str.equals("") ) break;
			
			sum += Integer.parseInt(str);
		}
		System.out.println(sum);
	}

}
