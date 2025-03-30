import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static int N;
	public static int[] arr, dist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		
		arr = new int[N];
		dist = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st1.nextToken());
			dist[i] = -1;				// 방문처리를 위해 기본값 -1로 세팅
		}
		
		int a = Integer.parseInt(st2.nextToken()) - 1;
		int b = Integer.parseInt(st2.nextToken()) - 1;
		
		bfs(a);
		
		System.out.println(dist[b]);
	}
	
	public static void bfs(int n) {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.offer(n);
		dist[n] = 0;
		
		while( !queue.isEmpty() ) {
			n = queue.poll();
			
			for(int i=arr[n]; i<N; i+=arr[n]) {
				// 앞으로 점프
				if( n+i < N && dist[n+i] == -1 ) {
					queue.offer(n+i);
					dist[n+i] = dist[n] + 1;
				}
				// 뒤로 점프
				if( n-i >= 0 && dist[n-i] == -1 ) {
					queue.offer(n-i);
					dist[n-i] = dist[n] + 1;
				}
			}
		}
	}

}
