import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		
		int milk = 0, cycle = 0;
		for(int i=0; i<N; i++) {
			if( cycle > 2 ) cycle = 0;
			
			if( Integer.parseInt(st.nextToken()) == cycle ) {
				cycle++;
				milk++;
			}
		}
		System.out.println(milk);
	}

}
