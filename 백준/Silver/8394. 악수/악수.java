import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		// 1. 2차원 배열 메모리 초과
//		long[][] dp = new long[N][2];
//		dp[0][0] = 0;				// 악수하는 경우 수
//		dp[0][1] = 1;				// 악수안하는 경우 수
//		for(int i=1; i<N; i++) {
//			dp[i][0] = dp[i-1][1];
//			dp[i][1] = dp[i-1][0] + dp[i-1][1]; 
//		}
//		System.out.println(dp[N-1][0]+dp[N-1][1]);
		
		long hand = 0, noHand = 1;
		for(int i=1; i<N; i++) {
			long tmp = hand;
			hand = noHand;
			noHand = (tmp + noHand) % 10;
		}
		System.out.println((hand+noHand)%10);
	}

}
