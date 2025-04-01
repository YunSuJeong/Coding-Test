import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	public static int N, M, max = 0;
	public static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[M][2];
		
		for(int i=0; i<M; i++) {
			StringTokenizer edge = new StringTokenizer(br.readLine());
			
			int s1 = Integer.parseInt(edge.nextToken()) - 1;
			int s2 = Integer.parseInt(edge.nextToken()) - 1;
			
			arr[i][0] = s1;
			arr[i][1] = s2;
		}
		
		// 최대 짝 개수 찾기
		boolean[] visited = new boolean[N];
		if( M > 0 ) dfs(visited, 0, 0);
		
		int maxCnt = max * 2;
		if( maxCnt < N ) maxCnt++;
		System.out.println(maxCnt);
	}

	public static void dfs(boolean[] visited, int idx, int cnt) {
		if( idx >= M ) {
			max = Math.max(max, cnt);
			return;
		}
		
		if( !visited[arr[idx][0]] && !visited[arr[idx][1]] ) {
			visited[arr[idx][0]] = true;
			visited[arr[idx][1]] = true;
			
			dfs(visited, idx+1, cnt+1);		// 현재 짝을 선택하는 경우

			visited[arr[idx][0]] = false;
			visited[arr[idx][1]] = false;
			
			dfs(visited, idx+1, cnt);		// 현재 짝을 선택하지 않는 경우
		} else {
			dfs(visited, idx+1, cnt);		// 현재 짝을 선택못하는 경우이므로 다음 엣지로 
		}
		
		
	}
}
