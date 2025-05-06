import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		boolean[] vip = new boolean[N+1];
		for(int i=0; i<M; i++) {
			vip[Integer.parseInt(br.readLine())] = true;
		}
		
		// 연속된 일반좌석 i개에 앉을 수 있는 방법 수
		int[] dp = new int[41];
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;
		for(int i=3; i<=40; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}

		
		// 총 방법 수 = vip좌석 기준으로 나눠진 각 일반좌석들 뭉탱이 내 앉을 수 있는 방법의 곱
		int sum = 1;
		int count = 0;			// vip좌석 기준으로 연속된 일반좌석의 수
		for(int i=1; i<=N; i++) {
			if( vip[i] ) {
				sum *= dp[count];
				count = 0;
			} else if( i == N ) {
				count++;
				sum *= dp[count];
			} else count++;
		}
		
		System.out.println(sum);
	}

}
