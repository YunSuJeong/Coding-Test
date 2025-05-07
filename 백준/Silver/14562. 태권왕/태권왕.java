import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static int S, T;
	public static int[][] dist = new int[201][201];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int C = Integer.parseInt(br.readLine());
		for(int tc=0; tc<C; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			S = Integer.parseInt(st.nextToken());
			T = Integer.parseInt(st.nextToken());
			
			for(int[] d : dist) Arrays.fill(d, Integer.MAX_VALUE);
			bfs(S, T);
			
			int min = Integer.MAX_VALUE;
			for(int i=1; i<=200; i++) min = Math.min(min, dist[i][i]);
			System.out.println(min);
		}
	}
	
	public static void bfs(int s, int t) {
		Queue<int[]> queue = new LinkedList<int[]>();
		
		queue.offer(new int[] {s, t});
		dist[s][t] = 0;
		
		while( !queue.isEmpty() ) {
			int[] tmp = queue.poll();
			
			s = tmp[0];
			t = tmp[1];
			
			if( 2 * s <= 200 & t + 3 <= 200 && dist[2*s][t+3] == Integer.MAX_VALUE ) {
				queue.offer(new int[] {2*s, t+3});
				dist[2*s][t+3] = dist[s][t] + 1;
			} 
			
			if( s + 1 <= 200 && dist[s+1][t] == Integer.MAX_VALUE ) {
				queue.offer(new int[] {s+1, t});
				dist[s+1][t] = dist[s][t] + 1;
			}
		}
	}

}
