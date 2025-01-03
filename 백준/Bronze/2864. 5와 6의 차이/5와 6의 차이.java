import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		
		String A = st.nextToken();
		String B = st.nextToken();
		
		int min = Integer.parseInt(A.replace("6", "5")) + Integer.parseInt(B.replace("6", "5"));
		int max = Integer.parseInt(A.replace("5", "6")) + Integer.parseInt(B.replace("5", "6"));
		
		System.out.printf("%d %d", min, max);
	}

}
