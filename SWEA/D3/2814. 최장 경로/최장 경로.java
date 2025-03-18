import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	
	public static int N, M, max = 1;
	public static List<ArrayList<Integer>> arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			// 무방향 그래프 인접리스트로 구현
			arr = new ArrayList<ArrayList<Integer>>();
			for(int i=0; i<=N; i++) {
				arr.add(new ArrayList<Integer>());
			}
			
			for(int i=1; i<=M; i++) {
				StringTokenizer edge = new StringTokenizer(br.readLine());
				
				int n1 = Integer.parseInt(edge.nextToken());
				int n2 = Integer.parseInt(edge.nextToken());
				
				arr.get(n1).add(n2);
				arr.get(n2).add(n1);
			}

            // dfs로 최장경로 구하기
			boolean[] visited;
			for(int i=1; i<=N; i++) {
				visited = new boolean[N+1];
				dfs(visited, i, 0);
			}
			
			System.out.printf("#%d %d\n", tc, max);
			max = 1;
		}
		
	}
	
	public static void dfs(boolean[] visited, int n, int depth) {
		visited[n] = true;
		depth++;
		// 더 이상 방문가능한 인접노드가 없다면 return
		int count = 0;
		for(int i : arr.get(n)) {
			if( !visited[i] ) {
				count++;
			}
		}
		if( count == 0 ) {
			max = Math.max(max, depth);
			visited[n] = false;
			return;
		} 
		
		for(int i : arr.get(n)) {
			if( !visited[i] ) dfs(visited, i, depth);
		}
		
		visited[n] = false;
	}

}
