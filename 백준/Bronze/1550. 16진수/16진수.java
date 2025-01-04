import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		int decimal = 0; 
		for(int i=0; i<str.length(); i++) {
			int digit = str.charAt(i);
			
			if( str.charAt(i) >= 65 ) decimal += (digit-55) * Math.pow(16, str.length()-1-i);	// A~F 계산
			else decimal += (digit-'0') * Math.pow(16, str.length()-1-i);						// 0~9 계산
		}
		
		System.out.println(decimal);
	}

}
