import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	
	public static int order = 1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		
		// 1. 인접행렬로 구현 -> 메모리 초과
//		int arr[][] = new int[N][N];
//		for(int i=0; i<M; i++) {
//			StringTokenizer st1 = new StringTokenizer(br.readLine());
//			int v1 = Integer.parseInt(st1.nextToken());
//			int v2 = Integer.parseInt(st1.nextToken());
//			for(int j=0; j<N; j++) {
//				arr[v1-1][v2-1] = 1;
//				arr[v2-1][v1-1] = 1;
//			}
//		}
//		
//		int visited[] = new int[N];
//		dfs1(arr, visited, N, M, R-1, 1);
//		
//		for(int v : visited) {
//			System.out.println(v);
//		}
		
		// 2. 인접리스트로 구현 
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for(int i=0; i<=N; i++)
			graph.add(new ArrayList<Integer>());
		
		for(int i=1; i<= M; i++) {
			StringTokenizer edge = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(edge.nextToken());
			int v2 = Integer.parseInt(edge.nextToken());
			
			graph.get(v1).add(v2);
			graph.get(v2).add(v1);
		}
		
		// 오름차순 정렬
		for(int i=1; i<=N; i++) {
			Collections.sort(graph.get(i));
		}
		
		int visited2[] = new int[N];
		dfs2(graph, visited2, R);
		
		for(int v : visited2) {
			System.out.println(v);
		}
	}
	
	// V : 정점 집합, E : 간선 집합, R : 시작 정점
//	public static void dfs1(int[][] arr, int[] visited, int V, int E, int R, int seq) {
//		visited[R] = seq;				// 방문 순서 저장
//		for(int i=0; i<V; i++) {
//			if( arr[R][i] > 0 && visited[i] == 0 ) {
//				dfs1(arr, visited, V, E, i, seq+1);
//			} 
//		}
//	}
	
	public static void dfs2(ArrayList<ArrayList<Integer>> graph, int[] visited, int R) {
		visited[R-1] = order++;				// 방문한 노드에 방문순서 저장 
		
		for(int v : graph.get(R)) {
			if( visited[v-1] == 0 ) dfs2(graph, visited, v);
		}
	}

}
