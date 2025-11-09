import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	
	public static char[] node;
	public static List<List<Integer>> edge;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1; tc<=10; tc++) {
			int n = Integer.parseInt(br.readLine());
			node = new char[n+1];
			edge = new ArrayList<List<Integer>>();
			
			for(int i=0; i<=n; i++) edge.add(new ArrayList<Integer>());
			
			for(int i=0; i<n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int len = st.countTokens();
				
				int v = 0, l = 0, r = 0;
				char c = '0';
				for(int j=0; j<len; j++) {
					if( j == 0 ) v = Integer.parseInt(st.nextToken());
					else if( j == 1 ) c = st.nextToken().charAt(0);
					else if( j == 2 ) l = Integer.parseInt(st.nextToken());
					else r = Integer.parseInt(st.nextToken());
				}
				
				node[v] = c;
				if( l > 0 ) edge.get(v).add(l);
				if( r > 0 ) edge.get(v).add(r);
			}
			
			inOrder(1);
			
			System.out.printf("#%d %s\n", tc, sb.toString());
			sb.setLength(0);
		}
	}
	
	public static void inOrder(int n) {
		if( edge.get(n).size() > 0 ) inOrder(edge.get(n).get(0));
		sb.append(node[n]);
		if( edge.get(n).size() == 2 ) inOrder(edge.get(n).get(1));
	}

}
