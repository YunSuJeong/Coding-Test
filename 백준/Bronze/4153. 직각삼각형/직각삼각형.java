import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = "";
		
		while( (str=br.readLine()) != null ) {
			
			StringTokenizer st = new StringTokenizer(str);
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if( a == 0 && b == 0 && c == 0 ) break;
			
			if( a*a + b*b == c*c || b*b + c*c == a*a || a*a + c*c == b*b ) System.out.println("right");
			else System.out.println("wrong");
			
		}
	}

}
