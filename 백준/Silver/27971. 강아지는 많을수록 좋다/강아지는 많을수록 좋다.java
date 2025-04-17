import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static int N, M, A, B;
	public static int[][] close;
	public static int[] magic = new int[2];
	public static int[] cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		magic[0] = A;
		magic[1] = B;
		
		close = new int[M][2];
		for(int i=0; i<M; i++) {
			StringTokenizer interval = new StringTokenizer(br.readLine());
			
			int L = Integer.parseInt(interval.nextToken());
			int R = Integer.parseInt(interval.nextToken());
			
			close[i][0] = L;
			close[i][1] = R;
		}
		
		cnt = new int[N+1];
		Arrays.fill(cnt, -1);
		
		bfs(0);
		
		System.out.println(cnt[N]);
	}
	
	public static void bfs(int num) {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.offer(num);
		cnt[num] = 0;
		
		while( !queue.isEmpty() ) {
			num = queue.poll();
			
			for(int i=0; i<2; i++) {
				int n = num + magic[i];
				
				boolean isCreate = true;
				for(int j=0; j<M; j++) {
					if( n >= close[j][0] && n <= close[j][1] ) {
						isCreate = false;
						break;
					}
				}
				
				if( n <= N && isCreate && cnt[n] == -1) {
					cnt[n] = cnt[num] + 1;
					queue.offer(n);
				}
			}
		}
	}

}
