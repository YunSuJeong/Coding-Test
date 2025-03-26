import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	public static int N, M;
	public static List<ArrayList<Integer>> arr;
	public static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new ArrayList<ArrayList<Integer>>();
		visited = new boolean[N+1];
		
		for(int i=0; i<=N; i++) {
			arr.add(new ArrayList<Integer>());
		}
		
		for(int i=0; i<M; i++) {
			StringTokenizer edge = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(edge.nextToken());
			int v = Integer.parseInt(edge.nextToken());
			
			// 무방향 그래프
			arr.get(u).add(v);			
			arr.get(v).add(u);			
		}
		
		int cnt = 0;
		for(int i=1; i<=N; i++) {
			if( !visited[i]) {
				dfs(i);
				cnt++;
			}
		}
		System.out.println(cnt);
	}
	
	public static void dfs(int n) {
		// 방문 처리
		visited[n] = true;
		
		// 현재 노드와 연결된 노드 탐색
		for(int i : arr.get(n) ) {
			if( !visited[i] ) dfs(i);
		}
	}

}
