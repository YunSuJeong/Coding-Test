import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		
		for(int i=0; i<str.length(); i++) {
			if( i == 0 )
				sb.append(Integer.toString(str.charAt(i)-'0', 2));
			else 
				sb.append(String.format("%03d", Integer.parseInt(Integer.toString(str.charAt(i)-'0', 2))));
		}
		System.out.println(sb.toString());
	}

}
