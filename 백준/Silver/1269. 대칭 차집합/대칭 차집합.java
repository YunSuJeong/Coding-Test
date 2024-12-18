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
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		String numA = br.readLine();
		String numB = br.readLine();
		
		StringTokenizer stA = new StringTokenizer(numA);
		StringTokenizer stB = new StringTokenizer(numB);
		
		Set<Integer> setA = new HashSet<Integer>();
		for(int i=0; i<A; i++) {
			setA.add(Integer.parseInt(stA.nextToken()));
		}
		
		int cntB = 0;
		for(int i=0; i<B; i++) {
			int b = Integer.parseInt(stB.nextToken());
			if( setA.contains(b) ) setA.remove(b);
			else cntB++;
		}
		
		System.out.println(setA.size()+cntB);
	}

}
