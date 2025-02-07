import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Set<String> dance = new HashSet<String>();
		Set<String> noDance = new HashSet<String>();
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String A = st.nextToken();
			String B = st.nextToken();
			if( (A.equals("ChongChong") || B.equals("ChongChong")) || (dance.contains(A) || dance.contains(B)) ) {
				dance.add(A);
				dance.add(B);
				noDance.remove(A);
				noDance.remove(B);
			} else {
				noDance.add(A);
				noDance.add(B);
			}
		}
        System.out.println(dance.size());
	}

}
