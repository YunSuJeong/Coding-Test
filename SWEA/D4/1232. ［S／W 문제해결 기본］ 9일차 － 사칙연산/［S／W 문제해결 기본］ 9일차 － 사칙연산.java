import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	
	public static List<List<Integer>> edge;
	public static String[] node;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1; tc<=10; tc++) {
			int v = Integer.parseInt(br.readLine());
			node = new String[v+1];
			edge = new ArrayList<List<Integer>>();
			
			for(int i=0; i<=v; i++) {
				edge.add(new ArrayList<Integer>());
			}
			
			for(int i=0; i<v; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				int n = 0, l = 0, r = 0;
				String val = "";
				int len = st.countTokens();
				for(int j=0; j<len; j++) {
					if( j == 0 ) n = Integer.parseInt(st.nextToken());
					else if( j == 1 ) val = st.nextToken();
					else if( j == 2 ) l = Integer.parseInt(st.nextToken());
					else r = Integer.parseInt(st.nextToken());
				}
				
				node[n] = val;
				if( l > 0 ) edge.get(n).add(l);
				if( r > 0 ) edge.get(n).add(r);
				
			}
			int result = (int) calc(1);
			System.out.printf("#%d %d\n", tc, result);
		}
	}
	
	public static double calc(int n) {
		if( edge.get(n).size() > 0 ) {
			double left = calc(edge.get(n).get(0));
			double right = calc(edge.get(n).get(1));
			
			double result;
			if( node[n].equals("+") ) result = left + right;
			else if( node[n].equals("-") ) result = left - right;
			else if( node[n].equals("*") ) result = left * right;
			else result = left / right;
			
			return result;
		} else {
			return Double.parseDouble(node[n]);
		}
	}

}
