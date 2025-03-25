import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	public static int N;
	public static int[] parent;
	public static List<ArrayList<Integer>> tree = new ArrayList<ArrayList<Integer>>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
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
		
		// dfs로 부모 노드 찾기
		parent = new int[N];
		dfs(parent, 0);
		
		for(int i=1; i<N; i++) {
			System.out.println(parent[i]);
		}
	}

	public static void dfs(int[] parent, int num) {
		for(int n : tree.get(num)) {
			if( parent[n] == 0 ) {
				parent[n] = num+1;		// 부모노드 저장
				dfs(parent, n);
			}
		}
	}
}
