import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		// dp[i] : 높이가 i일 때, 혼자 놀기를 통해 얻을 수 있는 즐거움의 총합의 최댓값
		int[] dp = new int[N+1];
		
		for(int i=0; i<=N; i++) {
			if( i < 2 ) dp[i] = i-1;
			else dp[i] = dp[i-1] + (i-1);
		}
		System.out.println(dp[N]);
	}

}
