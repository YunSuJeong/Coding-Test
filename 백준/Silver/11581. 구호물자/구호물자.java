import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	public static int N;
	public static boolean flag = false;
	public static List<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		for(int i=1; i<=N-1; i++) {
			int M = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<M; j++) {
				graph.get(i).add(Integer.parseInt(st.nextToken()));
			}
			
		}
		
		// 사이클 찾기
		int[] visited = new int[N+1];
		dfs(visited, 1);
		
		System.out.println(flag ? "CYCLE" : "NO CYCLE");
	}
	
	public static void dfs(int[] visited, int n) {
		if( flag ) return;

		if( visited[n] == -1 ) {
			flag = true;
			return;
		}

		visited[n] = 1;
		
		for(int i : graph.get(n)) {
			if( visited[i] == 0 ) {
				dfs(visited, i);
			} else if( visited[i] == 1 ) {
				visited[i] = -1;
				dfs(visited, i);
			}
		}
		visited[n] = 0;
	}

}
