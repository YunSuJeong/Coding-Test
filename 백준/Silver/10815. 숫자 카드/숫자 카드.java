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
		String str1 = br.readLine();
		int M = Integer.parseInt(br.readLine());
		String str2 = br.readLine();
		
		StringTokenizer st1 = new StringTokenizer(str1);
		StringTokenizer st2 = new StringTokenizer(str2);
		
		Set<Integer> setN = new HashSet<Integer>();
		for(int i=0; i<N; i++) {
			setN.add(Integer.parseInt(st1.nextToken()));
		}
		for(int i=0; i<M; i++) {
			if( setN.contains(Integer.parseInt(st2.nextToken())) ) System.out.print(1+" ");
			else System.out.print(0+" ");
		}
		
	}

}
