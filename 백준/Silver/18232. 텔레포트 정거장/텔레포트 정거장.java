import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static int N, S, E;
	public static List<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	public static int[] dist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st1.nextToken());
		int M = Integer.parseInt(st1.nextToken());
		S = Integer.parseInt(st2.nextToken());
		E = Integer.parseInt(st2.nextToken());
		
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<Integer>());
			
			if( i > 0 && i < N ) graph.get(i).add(i+1);
			
			if( i > 1 && i <= N ) graph.get(i).add(i-1);
		}
		
		for(int i=0; i<M; i++) {
			StringTokenizer edge = new StringTokenizer(br.readLine());
			
			int n1 = Integer.parseInt(edge.nextToken());
			int n2 = Integer.parseInt(edge.nextToken());
			
			graph.get(n1).add(n2);
			graph.get(n2).add(n1);
		}
		
		dist = new int[N+1];
		for(int i=0; i<=N; i++) {
			dist[i] = -1;
		}
		
		bfs(S);
		
		System.out.println(dist[E]);
	}

	public static void bfs(int n) {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.offer(n);
		dist[n] = 0;
		
		while( !queue.isEmpty() ) {
			n = queue.poll();
			
			for(int i : graph.get(n)) {
				if( dist[i] == -1 ) {
					dist[i] = dist[n] + 1;
					queue.offer(i);
				}
			}
		}
	}
}
