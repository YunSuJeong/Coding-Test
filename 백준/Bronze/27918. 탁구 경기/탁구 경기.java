import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int X = 0, Y = 0;
		for(int i=0; i<N; i++) {
			String win = br.readLine();
			
			if( win.equals("D") ) X++;
			else Y++;
			
			if( Math.abs(X-Y) >= 2 ) break;
		}
		System.out.printf("%d:%d", X, Y);
	}

}
