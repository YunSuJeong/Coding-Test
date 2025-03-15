import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static int N, cnt = 0;
	public static int[] arr;
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(br.readLine());
		
		arr = new int[N+1];
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		boolean[] visited = new boolean[N+1];
		dfs(visited, s);
		
		System.out.println(cnt);
	}

	public static void dfs(boolean[] visited, int idx) {
		visited[idx] = true;
		cnt++;
		
		int left = idx - arr[idx];
		int right = idx + arr[idx];
		
		if( left > 0 && !visited[left] ) dfs(visited, left);
		if( right <= N && !visited[right] ) dfs(visited, right);
	}
}
