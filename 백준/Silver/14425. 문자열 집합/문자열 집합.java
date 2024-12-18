import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Set<String> s = new HashSet<String>();
		for(int i=0; i<N; i++) {
			s.add(br.readLine());
		}
		
		int cnt = 0;
		for(int i=0; i<M; i++) {
			if( s.contains(br.readLine()) ) cnt++;
		}
		
		System.out.println(cnt);
	}

}
