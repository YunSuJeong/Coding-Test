import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int max = Integer.MIN_VALUE;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[i] = num;
			max = Math.max(max, num);
		}
		
		// 1. 시간 초과
//		int[] sum = new int[N-1];
//		for(int i=2; i<=N; i++) {					// 연속된 수의 개수
//			for(int j=0; j<=N-i; j++)	{			// i개 연속된 수의 묶음 개수
//				sum[j] = sum[j] + arr[j+i-1];		// 연속된 i개 수의 합 = 연속된 (i-1)개 수의 합 + 바로 다음 수
//				max = Math.max(max, sum[j]);
//			}	
//		}
//		System.out.println(max);
		
		// 2. O(n) 방식
		int[] dp = new int[N];						// N번째 수에서의 연속합의 최대값
		dp[0] = arr[0];								// dp[i]는 현재까지 연속된 수의 합과 현재값의 최댓값이 된다.
		int sumMax = arr[0];
		for(int i=1; i<N; i++) {
			dp[i] = Math.max(dp[i-1] + arr[i], arr[i]);
			sumMax = Math.max(sumMax, dp[i]);
		}
		System.out.println(sumMax);
		
	}

}
