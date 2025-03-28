import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static int N;
	public static int[] parent;
	public static List<ArrayList<Integer>> tree = new ArrayList<ArrayList<Integer>>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			tree.add(new ArrayList<Integer>());
		}
		
		// 트리 인접리스트로 구현
		for(int i=0; i<N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int n1 = Integer.parseInt(st.nextToken()) - 1;
			int n2 = Integer.parseInt(st.nextToken()) - 1;
			
			tree.get(n1).add(n2);
			tree.get(n2).add(n1);
		}
		
		// 1. dfs로 부모 노드 찾기
		parent = new int[N];
//		dfs(0);

		// 2. bfs로 부모 노드 찾기
		bfs(0);
		
		for(int i=1; i<N; i++) {
			sb.append(parent[i]+"\n");
		}
		System.out.println(sb.toString());
	}

	/*public static void dfs(int num) {
		for(int n : tree.get(num)) {
			if( parent[n] == 0 ) {
				parent[n] = num+1;		// 부모노드 저장
				dfs(n);
			}
		}
	}*/
	
	public static void bfs(int num) {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.offer(num);
		
		while( !queue.isEmpty() ) {
			int p = queue.poll();
			
			for(int n : tree.get(p)) {
				if( parent[n] == 0 ) {
					parent[n] = p+1;
					queue.offer(n);
				}
			}
		}
	}
}
