import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int arr[][] = new int[M+1][M+1];
			
			for(int i=1; i<=M; i++) {
				for(int j=0; j<=M; j++) {
					if( j == 0 || j == i ) arr[i][j] = 1;
					else arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
				}
			}
			sb.append(arr[M][N]+"\n");
		}
		System.out.println(sb.toString());
	}

}
