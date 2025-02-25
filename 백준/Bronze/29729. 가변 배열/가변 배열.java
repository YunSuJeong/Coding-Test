import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int S = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int size = S;
		int cnt = 0;
		for(int i=0; i<N+M; i++) {
			int cmd = Integer.parseInt(br.readLine());
			
			if( cmd == 1 ) cnt++;
			else cnt--;
			
			if( size < cnt ) size *= 2;
		}
		System.out.println(size);
	}

}
