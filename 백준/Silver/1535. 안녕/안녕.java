import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[2][N];
		int[][] dp = new int[101][N+1];			// N명까지 악수 했을 때, 각 체력 당 최대 기쁨
		
		StringTokenizer hp = new StringTokenizer(br.readLine());
		StringTokenizer joy = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			arr[0][i] = Integer.parseInt(hp.nextToken());
			arr[1][i] = Integer.parseInt(joy.nextToken());
		}
		
		for(int i=1; i<=100; i++) {
			for(int j=1; j<=N; j++) {
				if( arr[0][j-1] > i ) {				
					// j번째 사람의 체력보다 현재 체력이 적다면
					// 이전 사람까지 악수하여 얻은 기쁨
					dp[i][j] = dp[i][j-1];			
				} else {
					// j번째 사람의 체력보다 현재 체력이 같거나 많다면, 악수하는 선택/안하는 선택 중 최댓값을 저장
					// j번째 사람과 악수하지 않는 선택 = 이전 사람까지 악수하여 얻은 기쁨
					// j번째 사람과 악수하는 선택 = j번째 사람과 악수할 때 기쁨 + 남은 체력으(현재 체력 - j번째 사람과 악수하며 잃은 체력) 이전 사람과 악수하여 얻은 기쁨
					dp[i][j] = Math.max(dp[i][j-1], arr[1][j-1] + dp[i-arr[0][j-1]][j-1]);
				}
			}
		}
		
		int max = 0;
		for(int i=1; i<=N; i++) {
			max = Math.max(max, dp[99][i]);
		}

		System.out.println(max);
	}

}
