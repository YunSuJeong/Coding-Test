import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	
	public static String result = "F";
	public static List<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<26; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			
			int n1 = str.charAt(0) - 97;
			int n2 = str.charAt(str.length()-1) - 97;
			
			graph.get(n1).add(n2);
		}
		
		int m = Integer.parseInt(br.readLine());
		
		for(int i=0; i<m; i++) {
			String str = br.readLine();
			
			int n1 = str.charAt(0) - 97;
			int n2 = str.charAt(str.length()-1) - 97;
			
			dfs(n1, n2);
			sb.append(result+"\n");
			result = "F";
		}
		System.out.println(sb.toString());
	}
	
	public static void dfs(int n, int E) {
		if( n == E ) {
			result = "T";
			return;
		}
		
		for(int i : graph.get(n)) {
			dfs(i, E);
		}
	}
}
