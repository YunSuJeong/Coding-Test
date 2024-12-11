import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		StringTokenizer st = new StringTokenizer(str);
		
		int E = Integer.parseInt(st.nextToken())%15;
		int S = Integer.parseInt(st.nextToken())%28;
		int M = Integer.parseInt(st.nextToken())%19;
		
		
		int year = 1;
		while( true ) {
			if( year % 15 == E && year % 28 == S && year % 19 == M ) break;
			year++;
		}
		System.out.println(year);
	}

}
