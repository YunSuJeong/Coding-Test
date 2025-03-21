import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	public static int p1, p2, cnt = -1;
	public static List<ArrayList<Integer>> family = new ArrayList<ArrayList<Integer>>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		p1 = Integer.parseInt(st.nextToken()) - 1;
		p2 = Integer.parseInt(st.nextToken()) - 1;
		
		for(int i=0; i<N; i++) {
			family.add(new ArrayList<Integer>());
		}
		
		int M = Integer.parseInt(br.readLine());
		for(int i=0; i<M; i++) {
			StringTokenizer edge = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(edge.nextToken()) - 1;
			int y = Integer.parseInt(edge.nextToken()) - 1;
			
			// 부모 자식 관계 인접리스트로 구현
			family.get(x).add(y);
			family.get(y).add(x);
		}
		
		// dfs로 두 사람의 촌수 계산 = 엣지 개수 세기
		boolean[] visited = new boolean[N];
		dfs(visited, p1, 0);
		
		System.out.println(cnt);
	}

	public static void dfs(boolean[] visited, int i, int sum) {
		visited[i] = true;
		
		for( int n : family.get(i) ) {
			if( n == p2 ) {
				cnt = sum + 1;
				return;
			} else {
				if( !visited[n] ) dfs(visited, n, sum+1);
			}
		}
	}
}
