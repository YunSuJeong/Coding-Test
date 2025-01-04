import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str = "";
		
		while( (str=br.readLine()) != null ) {
			
			if( str.equals("0") ) break;
			
			int sum = 0;
			for(int i=0; i<str.length(); i++) {
				sum += (str.charAt(i)-'0') * factorial(str.length()-i);
			}
			sb.append(sum+"\n");
		}
		System.out.println(sb.toString());
	}
	
	public static int factorial(int n) {
		int multi = 1;
		for(int i=1; i<=n; i++) {
			multi *= i;
		}
		return multi;
	}

}
