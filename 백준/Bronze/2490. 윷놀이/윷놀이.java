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
			
			int cnt = 0;
			for(String s : str.split(" ")) {
				if( Integer.parseInt(s) == 0 ) cnt++; 
			}
			
			if( cnt == 0 ) {
				sb.append("E\n");
			} else if( cnt == 1) {
				sb.append("A\n");
			} else if( cnt == 2 ) {
				sb.append("B\n");
			} else if( cnt == 3 ) {
				sb.append("C\n");
			} else {
				sb.append("D\n");
			}
		}
		
		System.out.println(sb.toString());
	}

}
