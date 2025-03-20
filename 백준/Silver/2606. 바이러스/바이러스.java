import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static int cnt = 0;
	public static boolean[] visited;
	public static List<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	public static Queue<Integer> queue = new LinkedList<Integer>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int L = Integer.parseInt(br.readLine());
		
		// 1. 인접행렬 & 막 구현한 dfs
		/*int network[][] = new int[N+1][N+1];
		for(int i=0; i<L; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			network[a][b] = 1;
			network[b][a] = 1;
		}
		int arr[] = new int[N+1];
		for(int i=2; i<=N; i++) {
			if( network[1][i] > 0 ) arr = search(network, arr, 1, i, N);
		}
		
		int cnt = 0;
		for(int i=2; i<=N; i++) {
			if( arr[i] > 0 ) cnt++;
		}
		System.out.println(cnt);*/
		
		// 2. 인접리트 & bfs로 풀어보기
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		for(int i=0; i<L; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			
			// 무방향 그래프 세팅
			graph.get(n1).add(n2);
			graph.get(n2).add(n1);
		}
		
		visited = new boolean[N+1];
		bfs(1);
		
		System.out.println(cnt-1);		// 1번 컴퓨터는 개수에서 제외
	}
	
	public static void bfs(int n) {
		queue.add(n);
		
		int idx = queue.poll();
		visited[idx] = true;			// 방문처리
		cnt++;
		
		for(int i : graph.get(idx)) {
			if( !visited[i] ) bfs(i);
		}
	}
	
	/*public static int[] search(int[][] network, int[] arr, int a, int b, int n) {
		if( a > n || b > n ) return arr;
		else if( network[a][b] == 0 || network[a][b] == 2 ) return search(network, arr, a, b+1, n);
		else {
			arr[b] = 1;
			network[a][b] = 2;
			network[b][a] = 2;
			for(int i=2; i<=n; i++) {
				search(network, arr, b, 1, n);
			}
			return arr;
		}
	}*/

}
