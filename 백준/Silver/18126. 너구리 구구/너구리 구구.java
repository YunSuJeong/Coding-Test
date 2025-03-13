import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	public static long max = 0;
	public static int[][] dist;
	public static List<ArrayList<Integer>> room = new ArrayList<ArrayList<Integer>>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<=N; i++) {
			room.add(new ArrayList<Integer>());
		}
		
		dist = new int[N+1][N+1];
		
		for(int i=0; i<N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			// 인접리스트로 연결된 방 구현 (양방향)
			room.get(A).add(B);
			room.get(B).add(A);
			
			// 거리 저장
			dist[A][B] = C;
			dist[B][A] = C;
		}
		
		boolean[] visited = new boolean[N+1];
		dfs(visited, 1, 0);
		
		System.out.println(max);
 	}
	
	public static void dfs(boolean[] visited, int n, long sum) {
		visited[n] = true;
		
		int cnt = 0;
		for(int r : room.get(n)) {
			if( !visited[r] ) cnt++;
		}
		
		if( cnt == 0 ) {
			max = Math.max(max, sum);
			visited[n] = false;
			return;
		}
		
		for(int r : room.get(n)) {
			if( !visited[r] ) dfs(visited, r, sum+dist[n][r]);
		}
		
		visited[n] = false;
	}

}
