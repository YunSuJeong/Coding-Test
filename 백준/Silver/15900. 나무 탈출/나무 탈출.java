import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	public static int sum = 0;
	public static List<ArrayList<Integer>> tree = new ArrayList<ArrayList<Integer>>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<=N; i++) {
			tree.add(new ArrayList<Integer>());
		}
		
		for(int i=0; i<N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			
			tree.get(n1).add(n2);
			tree.get(n2).add(n1);
		}
		
		// dfs로 리프노드들의 depth합 구하기
		boolean[] visited = new boolean[N+1];
		dfs(visited, 0, 1);
		
		// 모든 리프노드의 depth의 합이 짝수면 지고 홀수면 이긴다.
		System.out.println(sum % 2 == 0 ? "No" : "Yes");
	}
	
	public static void dfs(boolean[] visited, int depth, int n) {
		visited[n] = true;
		
		// 리프노드인지 확인
		int cnt = 0;
		for(int i : tree.get(n)) {
			if( !visited[i] ) cnt++;
		}
		
		if( cnt == 0 ) {
			sum += depth;
			return;
		}
		
		for(int i : tree.get(n)) {
			if( !visited[i] ) dfs(visited, depth+1, i);
		}
	}
}
