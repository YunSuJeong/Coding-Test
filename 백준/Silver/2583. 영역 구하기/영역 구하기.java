import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	
	public static int M, N, area = 0;
	public static int[][] arr;
	
	public static int[] X = {-1, 1, 0, 0};
	public static int[] Y = {0, 0, -1, 1};
 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		arr = new int[M+1][N+1];
		for(int i=0; i<K; i++) {
			StringTokenizer rect = new StringTokenizer(br.readLine());
			
			int x1 = Integer.parseInt(rect.nextToken());
			int y1 = Integer.parseInt(rect.nextToken());
			int x2 = Integer.parseInt(rect.nextToken());
			int y2 = Integer.parseInt(rect.nextToken());
			
			for(int y=y1; y<y2; y++) {
				for(int x=x1; x<x2; x++) {
					arr[y][x] = 1;
				}
			}
		}
		
		int cnt = 0;
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if( arr[i][j] == 0 ) {
					area = 0;
					bfs(i, j);
					cnt++;
					list.add(area);
				}
			}
		}
		
		Collections.sort(list);
		
		System.out.println(cnt);
		for(int s : list) sb.append(s+" ");
		System.out.println(sb.toString());
 	}
	
	public static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<int[]>();
		
		queue.offer(new int[] {x, y});
		area++;
		arr[x][y] = 2;
		
		while( !queue.isEmpty() ) {
			int[] tmp = queue.poll();
			
			x = tmp[0];
			y = tmp[1];
			
			for(int i=0; i<4; i++) {
				int a = x + X[i];
				int b = y + Y[i];
				
				if( a >= 0 && a < M && b >= 0 && b < N && arr[a][b] == 0) {
					arr[a][b] = 2;
					queue.offer(new int[] {a, b});
					area++;
				}
			}
		}
		
	}

}
