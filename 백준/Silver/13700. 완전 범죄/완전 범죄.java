import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static int N, S, D, F, B, K;
	public static int[] arr, dist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringTokenizer l = null;
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		F = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		if( K > 0 ) l = new StringTokenizer(br.readLine());
		
		arr = new int[N];
		for(int i=0; i<K; i++) {
			int p = Integer.parseInt(l.nextToken());
			
			arr[p-1] = -1;			// 경찰서 -1로 세팅
		}
		
		dist = new int[N];
		Arrays.fill(dist, -1);
		bfs(S-1);
		
		System.out.println(dist[D-1] >= 0 ? dist[D-1] : "BUG FOUND");
	}
	
	public static void bfs(int n) {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		dist[n] = 0;
		queue.offer(n);
		
		while( !queue.isEmpty() ) {
			n = queue.poll();
			
			if( n == D-1 ) break;
			// 앞으로 달리기
			int i = n + F;
			if( i < N && dist[i] == -1 && arr[i] == 0 ) {
				queue.offer(i);
				dist[i] = dist[n] + 1;
			}
			
			// 뒤로 달리기
			i = n - B;
			if( i >= 0 && dist[i] == -1 && arr[i] == 0 ) {
				queue.offer(i);
				dist[i] = dist[n] + 1;
			}
		}
	}

}
