
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
		
		int[][] arr = new int[N][2];
		for(int i=0; i<N; i++) {
			StringTokenizer stuff = new StringTokenizer(br.readLine());
			
			int W = Integer.parseInt(stuff.nextToken());
			int V = Integer.parseInt(stuff.nextToken());
			
			arr[i][0] = W;
			arr[i][1] = V;
		}
		
		int[][] value = new int[K+1][N+1];
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=K; j++) {
				if( j >= arr[i-1][0] ) {
					value[j][i] = Math.max(value[j][i-1], value[j-arr[i-1][0]][i-1] + arr[i-1][1]);
				} else {
					value[j][i] = Math.max(value[j][i-1], value[j][i-1]);
				}
			}
		}
		System.out.println(value[K][N]);
	}

}
