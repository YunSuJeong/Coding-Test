import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	public static int N, M, cnt = 0;
	public static List<ArrayList<Integer>> task = new ArrayList<ArrayList<Integer>>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N; i++) {
			task.add(new ArrayList<Integer>());
		}
		
		for(int i=0; i<M; i++) {
			StringTokenizer t = new StringTokenizer(br.readLine());
			
			int t1 = Integer.parseInt(t.nextToken()) - 1;
			int t2 = Integer.parseInt(t.nextToken()) - 1;
			
			task.get(t2).add(t1);
		}
		
		int X = Integer.parseInt(br.readLine()) - 1;
		boolean[] visited = new boolean[N];
		dfs(visited, X);
		
		System.out.println(cnt);
	}
	
	public static void dfs(boolean[] visited, int n) {
		visited[n] = true;
		
		for(int i : task.get(n)) {
			if( !visited[i] ) {
				dfs(visited, i);
				cnt++;
			}
		}
	}

}
