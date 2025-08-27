import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static char[] arr, perm;
	public static int N, count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = "";
		
		while( (str=br.readLine()) != null ) {
			count = 0;
			StringTokenizer st = new StringTokenizer(str);
			StringBuilder sb = new StringBuilder();
			
			arr = st.nextToken().toCharArray();
			perm = new char[arr.length];
			N = Integer.parseInt(st.nextToken());
			
			boolean[] visited = new boolean[arr.length];
			String perm = permutation(visited, 0);
			
			System.out.printf("%s %s %s\n", str, "=", perm == null ? "No permutation" : perm);
		}
	}
	
	public static String permutation(boolean[] visited, int depth) {
		if( depth == arr.length ) {
			count++;
			if( count == N ) return new String(perm);
			else return null;
		}
		
		for(int i=0; i<arr.length; i++) {
			if( !visited[i] ) {
				visited[i] = true;
				perm[depth] = arr[i];
				String result = permutation(visited, depth+1);
				visited[i] = false;
				
				if( result != null ) return result;
			}
 		}
		
		return null;
	}

}
