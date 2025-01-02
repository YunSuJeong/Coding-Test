import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = "";
		
		int num = 1;
		while( (str=br.readLine()) != null ) {
			
			if( str.equals("0") ) break;
			
			StringTokenizer st = new StringTokenizer(str);
			
			int r = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			
			if( w*w + l*l <= r*r*4 ) {
				System.out.printf("Pizza %d fits on the table.\n", num);
			} else {
				System.out.printf("Pizza %d does not fit on the table.\n", num);
			}
			num++;
		}
	}

}
