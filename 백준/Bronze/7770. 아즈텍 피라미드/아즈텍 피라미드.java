import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		int n = Integer.parseInt(br.readLine());
		
		int block = 1, prev = 1, h = 1;
		
		while(true) {
			if( n < block ) break;
			
			h++;
			prev += 4*(h-1);
			block += prev;
		}
		System.out.println(h-1);
	}

}
