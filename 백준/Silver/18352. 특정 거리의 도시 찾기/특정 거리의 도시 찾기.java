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
	
	public static int N, M, K, X;
	public static List<ArrayList<Integer>> city = new ArrayList<ArrayList<Integer>>();
	public static List<Integer> X_city = new ArrayList<Integer>();
	public static int[] dist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		dist = new int[N+1];
		for(int i=0; i<=N; i++) {
			city.add(new ArrayList<Integer>());
			dist[i] = -1;
		}
		
		for(int i=0; i<M; i++) {
			StringTokenizer road = new StringTokenizer(br.readLine());
			
			int A = Integer.parseInt(road.nextToken());
			int B = Integer.parseInt(road.nextToken());
			
			city.get(A).add(B);		// 단방향 도로 세팅
		}
		
		dfs(X);
		
		Collections.sort(X_city);	// 오름차순 정렬
		
		if( X_city.isEmpty() ) sb.append(-1);
		else {
			for(int i : X_city) {
				sb.append(i+"\n");
			}
		}
		System.out.println(sb.toString());
	}
	
	public static void dfs(int n) {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.offer(n);
		dist[n] = 0;
		
		while( !queue.isEmpty() ) {
			n = queue.poll();
			
			// 최단거리 = K 인, 도시 저장
			if( dist[n] == K ) X_city.add(n);
				
			for(int i : city.get(n)) {
				if( dist[i] == -1 ) {
					queue.offer(i);
					dist[i] = dist[n] + 1;
				}
			}
		}
	}

}
