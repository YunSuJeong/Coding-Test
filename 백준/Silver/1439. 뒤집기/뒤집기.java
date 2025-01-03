import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		char tmp = str.charAt(0);
		
		// 0, 1의 모둠 개수 구하기
		int zero = 0, one = 0;
		for(int i=1; i<str.length(); i++) {
			if( tmp != str.charAt(i) ) {
				if( tmp == '0' ) zero++;
				else one++;
				
				tmp = str.charAt(i);
			}
		}
		if( tmp == '0' ) zero++;
		else one++;
		
		if( zero == 0 || one == 0 ) System.out.println(0);
		else System.out.println(Math.min(zero, one));
	}

}
