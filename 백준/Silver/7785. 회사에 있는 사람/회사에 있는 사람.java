import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		Set<String> set = new HashSet<String>();
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			
			String name = st.nextToken();
			String log = st.nextToken();
			
			if( log.equals("enter") ) set.add(name);
			else set.remove(name);
		}
		
		List<String> list = new ArrayList<String>(set);
		
		Collections.sort(list, Collections.reverseOrder());
		
		for(String name : list) {
			System.out.println(name);
		}
	}

}
