import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int max = 0, current = 0;
		for(int i=0; i<4; i++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			
			int out = Integer.parseInt(st.nextToken());
			int in = Integer.parseInt(st.nextToken());
			
			current = current - out + in;
			max = Math.max(max, current);
		}
		
		System.out.println(max);
	}

}
