import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static int a, b, N, M;
	public static List<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	public static int dist[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		
		a = Integer.parseInt(st1.nextToken());
		b = Integer.parseInt(st1.nextToken());
		N = Integer.parseInt(st2.nextToken());
		M = Integer.parseInt(st2.nextToken());
		
		dist = new int[N+1];
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<Integer>());
			dist[i] = -1;
		}
		
		for(int i=0; i<M; i++) {
			StringTokenizer edge = new StringTokenizer(br.readLine());
			
			int n1 = Integer.parseInt(edge.nextToken());
			int n2 = Integer.parseInt(edge.nextToken());
			
			graph.get(n1).add(n2);
			graph.get(n2).add(n1);
		}
		
		bfs(a);
		
		System.out.println(dist[b]);
	}
	
	public static void bfs(int n) {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.offer(n);
		dist[n] = 0;
		
		while( !queue.isEmpty() ) {
			n = queue.poll();
			
			for(int i : graph.get(n)) {
				// 아직 치환된 적이 없는 문자라면 
				if( dist[i] == -1 ) {
					dist[i] = dist[n] + 1;
					queue.offer(i);
				}
			}
		}
	}
}