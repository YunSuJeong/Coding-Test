import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String[][] arr = new String[N][N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = st.nextToken();
			}
		}
		
		String[][] dp = new String[N][N];
		dp[0][0] = arr[0][0];
		for(int i=1; i<N; i++) {
			dp[0][i] = dp[0][i-1] + arr[0][i];
			dp[i][0] = dp[i-1][0] + arr[i][0];
		}
		
		for(int i=1; i<N; i++) {
			for(int j=1; j<N; j++) {
				dp[i][j] = (Long.parseLong(dp[i-1][j],2) > Long.parseLong(dp[i][j-1],2) ? dp[i-1][j] : dp[i][j-1]) + arr[i][j];
			}
		}
		
		System.out.println(Long.parseLong(dp[N-1][N-1], 2));
	}

}
