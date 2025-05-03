import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	
	public static boolean flag = true;			// 작은 세상 네트워크 조건 확인용 플래그
	public static int N, M;
	public static List<ArrayList<Integer>> network = new ArrayList<ArrayList<Integer>>();
	public static int[] dist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N; i++) {
			network.add(new ArrayList<Integer>());
		}
		
		for(int i=0; i<M; i++) {
			StringTokenizer friend = new StringTokenizer(br.readLine());
			
			int A = Integer.parseInt(friend.nextToken()) - 1;
			int B = Integer.parseInt(friend.nextToken()) - 1;
			
			network.get(A).add(B);
			network.get(B).add(A);
		}
		
		dist = new int[N];
		for(int i=0; i<N; i++) {
			if( !flag ) break;
			
			Arrays.fill(dist, -1);
			bfs(i);
			
			// 연결되어 있지 않은 사람이 있는지 체크
			for(int d : dist) {
				if( d < 0 ) {
					flag = false;
					break;
				} 
			}
		}
		System.out.println(flag ? "Small World!" : "Big World!");
	}

	public static void bfs(int n) {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.offer(n);
		dist[n] = 0;
		
		while( !queue.isEmpty() ) {
			n = queue.poll();
			
			// 연결은 되어있지만 관계가 6단계 이하가 아닌 경우
			if( dist[n] > 6 ) {
				flag = false;
				break;
			}
			
			for(int i : network.get(n) ) {
				if( dist[i] == -1 ) {
					dist[i] = dist[n] + 1;
					queue.offer(i);
				}
			}
		}
	}
}
