import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	
	public static int K = 0;
	public static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<T; tc++) {
			N = Integer.parseInt(br.readLine());
			
			ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
			for(int i=0; i<=N; i++) graph.add(new ArrayList<Integer>());
			
			for(int i=0; i<N; i++) {
				graph.get(i+1).add(Integer.parseInt(br.readLine()));
			}
			
			int visited[] = new int[N+1];
			K = 0;									// 새로운 테스트케이스마다 초기화
			dfs(graph, visited, 1);					// 시작노드는 무조건 1 고정
			
			System.out.println(visited[N]);
		}
	}
	
	public static void dfs(ArrayList<ArrayList<Integer>> graph, int[] visited, int R) {
		visited[R] = K++;
		
		for(int v : graph.get(R)) {
			if( visited[v] == 0 ) dfs(graph, visited, v);
		}
	}

}
