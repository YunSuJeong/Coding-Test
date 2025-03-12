import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	public static int N, K, apple = 0;
	public static int[] arr;
	public static List<ArrayList<Integer>> tree = new ArrayList<ArrayList<Integer>>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		for(int i=0; i<N; i++) {
			tree.add(new ArrayList<Integer>());
		}
		
		for(int i=0; i<N-1; i++) {
			StringTokenizer edge = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(edge.nextToken());
			int n2 = Integer.parseInt(edge.nextToken());
			tree.get(n1).add(n2);
		}
		
		// 각 노드의 사과 수 저장
		arr = new int[N];
		StringTokenizer apples = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(apples.nextToken());
		}
		
		dfs(0, 0);
		
		System.out.println(apple);
	}
	
	public static void dfs(int depth, int node) {
		if( arr[node] > 0 ) apple++;
		
		if( depth == K ) return;
		
		for( int n : tree.get(node) ) {
			dfs(depth+1, n);
		}
	}

}
