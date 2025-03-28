import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static int N, M;
	public static boolean[] visited1, visited2;
	public static List<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	public static StringBuilder sb = new StringBuilder();
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<Integer>());
		}
					
		
		for(int i=0; i<M; i++) {
			StringTokenizer edge = new StringTokenizer(br.readLine());
			
			int n1 = Integer.parseInt(edge.nextToken());
			int n2 = Integer.parseInt(edge.nextToken());
			
			// 양방향 그래프
			graph.get(n1).add(n2);
			graph.get(n2).add(n1);
		}
		
		// dfs
		visited1 = new boolean[N+1];
		dfs(V);
		System.out.println(sb.toString());
		sb.setLength(0);
		
		// bfs
		visited2 = new boolean[N+1];
		bfs(V);
		System.out.println(sb.toString());
	}
	
	public static void dfs(int n) {
		visited1[n] = true;
		sb.append(n+" ");

		if( graph.get(n).isEmpty() ) return;
		
		Collections.sort(graph.get(n));
		for(int a : graph.get(n) ) {
			if( !visited1[a] ) dfs(a);
		}
	}

	public static void bfs(int n) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(n);
		visited2[n] = true;
		
		while( !queue.isEmpty() ) {
			n = queue.poll();
			
			sb.append(n+" ");
			
			Collections.sort(graph.get(n));
			
			for(int a : graph.get(n) ) {
				if( !visited2[a] ) {
					visited2[a] = true;
					queue.offer(a);
				}
			}
		}
	}
}
