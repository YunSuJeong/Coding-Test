import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str = "";
		
		while( (str=br.readLine()) != null ) {
			
			if( str.equals("0") ) break;
			
			StringTokenizer st = new StringTokenizer(str);
			int N = Integer.parseInt(st.nextToken());
			int prev = Integer.parseInt(st.nextToken());
			sb.append(prev+" ");

			for(int i=0; i<N-1; i++) {
				int cur = Integer.parseInt(st.nextToken());
				
				if( prev != cur ) sb.append(cur+" ");
				
				prev = cur;
			}
			sb.append("$\n");
		}
		
		System.out.println(sb.toString());
	}

}
