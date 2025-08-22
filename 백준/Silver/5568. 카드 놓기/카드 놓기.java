import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	
	public static int n, k, count = 0;
	public static String[] arr;
	public static Set<String> set = new HashSet<String>();		// 중복 카운팅 체크용 set

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		arr = new String[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = br.readLine();
		}
		
		boolean[] visited = new boolean[n];
		combi(0, visited, "");
		
		System.out.println(count);
	}

	
	public static void combi(int depth, boolean[] visited, String str) {
		if( depth == k ) {
			if( !set.contains(str) ) {
				set.add(str);
				count++;
			}
			return;
		}
		
		for(int i=0; i<n; i++) {
			if( !visited[i] ) {
				visited[i] = true;
				combi(depth+1, visited, str+arr[i]);
				visited[i] = false;
			}
		}
	}
}
