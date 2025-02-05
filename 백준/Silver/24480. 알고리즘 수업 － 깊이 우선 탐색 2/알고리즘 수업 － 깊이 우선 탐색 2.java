import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	
	// 방문 순서
	public static int order = 1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<=N; i++) graph.add(new ArrayList<Integer>());
		
		// 주어진 간선만큼 그래프 저장
		for(int i=0; i<M; i++) {
			StringTokenizer edge = new StringTokenizer(br.readLine());
			
			int v1 = Integer.parseInt(edge.nextToken());
			int v2 = Integer.parseInt(edge.nextToken());
			
			// undirected graph이므로 양방향 모두 저장
			graph.get(v1).add(v2);
			graph.get(v2).add(v1);
		}
		
		// 각 정점의 인접한 정점 내림차순으로 정렬
		for(int i=1; i<=N; i++) {
			Collections.sort(graph.get(i), Collections.reverseOrder());
		}
		
		// dfs
		int visited[] = new int[N+1];
		dfs(graph, visited, R);
		
		// 방문 순서 출력
		for(int i=1; i<=N; i++) {
			System.out.println(visited[i]);
		}
	}
	
	// 깊이우선탐색 함수
	public static void dfs(ArrayList<ArrayList<Integer>> graph, int[] visited, int R) {
		// 방문 순서 저장
		visited[R] = order++;
		
		// 인접한 노드 중
		for(int v : graph.get(R)) {
			if( visited[v] == 0 ) dfs(graph, visited, v);
		}
	}

}
