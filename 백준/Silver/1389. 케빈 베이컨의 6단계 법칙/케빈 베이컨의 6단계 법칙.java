import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	
	public static int N, M;
	public static List<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	public static int[] dist;
	public static int[] cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer user = new StringTokenizer(br.readLine());
		N = Integer.parseInt(user.nextToken());
		M = Integer.parseInt(user.nextToken());
		
		dist = new int[N];
		cnt = new int[N];
		for(int i=0; i<N; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		// 인접리스트로 관계 저장
		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int n1 = Integer.parseInt(st.nextToken()) - 1;
			int n2 = Integer.parseInt(st.nextToken()) - 1;
			
			graph.get(n1).add(n2);
			graph.get(n2).add(n1);
		}
		
		int min = Integer.MAX_VALUE;
		for(int i=0; i<N; i++) {
			Arrays.fill(dist, -1);
			bfs(i);
			
			min = Math.min(min, cnt[i]);
		}
		
		for(int i=0; i<N; i++) {
			if( min == cnt[i] ) {
				System.out.println(i+1);
				break;
			}
		}
	}

	public static void bfs(int n) {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.offer(n);
		dist[n] = 0;
		int idx = n;
		
		while( !queue.isEmpty() ) {
			n = queue.poll();
			
			for(int i : graph.get(n)) {
				if( dist[i] == -1 ) {
					queue.offer(i);
					dist[i] = dist[n] + 1;
				}
			}
		}
		
		for(int d : dist) {
			cnt[idx] += d;
		}
	}
}
