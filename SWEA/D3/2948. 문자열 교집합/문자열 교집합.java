import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			StringTokenizer Ni = new StringTokenizer(br.readLine());
			StringTokenizer	Mi = new StringTokenizer(br.readLine());
			
			Set<String> setN = new HashSet<String>();
			Set<String> setM = new HashSet<String>();
			
			for(int i=0; i<N; i++) {
				setN.add(Ni.nextToken());
			}
			for(int i=0; i<M; i++) {
				setM.add(Mi.nextToken());
			}
			
			int cnt = 0;
			for(String n : setN) {
				if( setM.contains(n) ) cnt++;
			}
			System.out.printf("#%d %d\n", tc, cnt);
		}
	}

}
