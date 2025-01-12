import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str1 = br.readLine();
		String str2 = br.readLine();
		String str3 = br.readLine();
		
		int n = 0;
		if( str1.charAt(0) >= 48 && str1.charAt(0) <= 57 ) n = Integer.parseInt(str1)+3;
		else if( str2.charAt(0) >= 48 && str2.charAt(0) <= 57 ) n = Integer.parseInt(str2)+2;
		else if( str3.charAt(0) >= 48 && str3.charAt(0) <= 57 ) n = Integer.parseInt(str3)+1;
		
		if( n % 3 == 0 && n % 5 == 0 ) System.out.println("FizzBuzz");
		else if( n % 3 == 0 && n % 5 != 0 ) System.out.println("Fizz");
		else if( n % 3 != 0 && n % 5 == 0 ) System.out.println("Buzz");
		else System.out.println(n);
	}

}
