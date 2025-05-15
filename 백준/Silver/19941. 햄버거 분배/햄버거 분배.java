import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		char[] arr = br.readLine().toCharArray();
		boolean[] visited = new boolean[N];
		
		int cnt = 0;
		for(int i=0; i<N; i++) {
			if( arr[i] == 'P' ) {
				// K만큼 떨어져 있 햄버거 중 가장 왼쪽에 있는 햄버거 먹기
				for(int j=i-K; j<=i+K; j++) {
					if( j >= 0 && j < N && arr[j] == 'H' && !visited[j] ) {
						cnt++;
						visited[j] = true;
						break;
					}
				}
			}
		}
		System.out.println(cnt);
 	}

}
