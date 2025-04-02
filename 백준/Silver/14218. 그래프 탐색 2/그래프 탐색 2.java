import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static int n;
	public static int[] dist;
	public static List<ArrayList<Integer>> city = new ArrayList<ArrayList<Integer>>();
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		dist = new int[n];
		for(int i=0; i<n; i++) {
			city.add(new ArrayList<Integer>());
		}
		
		// 정비 전 도로
		for(int i=0; i<m; i++) {
			StringTokenizer def = new StringTokenizer(br.readLine());
			
			int c1 = Integer.parseInt(def.nextToken()) - 1;
			int c2 = Integer.parseInt(def.nextToken()) - 1;
			
			city.get(c1).add(c2);
			city.get(c2).add(c1);
		}
		
		// 정비
		int q = Integer.parseInt(br.readLine());
		for(int i=0; i<q; i++) {
			StringTokenizer road = new StringTokenizer(br.readLine());
			int c1 = Integer.parseInt(road.nextToken()) - 1;
			int c2 = Integer.parseInt(road.nextToken()) - 1;
			
			// 정비된 도로 추가
			city.get(c1).add(c2);
			city.get(c2).add(c1);
			
			init();
			bfs(0);
			
			result.append(sb.toString()+"\n");
			sb.setLength(0);
		}
		System.out.println(result.toString());
	}
	
	public static void bfs(int idx) {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.offer(idx);
		dist[0] = 0;
		
		while( !queue.isEmpty() ) {
			idx = queue.poll();
			
			for(int i : city.get(idx)) {
				if( dist[i] == -1 ) {
					queue.offer(i);
					dist[i] = dist[idx] + 1;
				}
			}
		}
		
		for(int i=0; i<n; i++) {
			sb.append(dist[i]+" ");
		}
	}

	public static void init() {
		for(int i=0; i<n; i++) {
			dist[i] = -1;
		}
	}
}
