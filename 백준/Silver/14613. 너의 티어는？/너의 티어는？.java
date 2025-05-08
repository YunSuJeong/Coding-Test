import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		double W = Double.parseDouble(st.nextToken());
		double L = Double.parseDouble(st.nextToken());
		double D = Double.parseDouble(st.nextToken());
		
		// dp[i][j] = i번째 랭크게임 일 때, 각 점수일 확률 
		double[][] dp = new double[21][3550];
		dp[1][1950] = L;
 		dp[1][2000] = D;
 		dp[1][2050] = W;
 		
 		for(int i=2; i<=20; i++) {
 			for(int j=1000; j<3500; j++) {
 				// 현재 점수일 확률 = (현재 점수-50점)에서 이길 확률 + 현재 점수에서 비길 확률 + (현재 점수 + 50점)에서 질 확률
 				dp[i][j] = dp[i-1][j-50] * W + dp[i-1][j] * D + dp[i-1][j+50] * L;
 			}
 		}
 		
 		double bronze = 0, silver = 0, gold = 0, platinum = 0, diamond = 0;
 		for(int i=1000; i<3500; i++) {
 			if( i < 1500 ) {
 				bronze += dp[20][i];
 			} else if( i < 2000 ) {
 				silver += dp[20][i];
 			} else if( i < 2500 ) {
 				gold += dp[20][i];
 			} else if( i < 3000 ) {
 				platinum += dp[20][i];
 			} else {
 				diamond += dp[20][i];
 			}
 		}
 		
 		System.out.printf("%.8f %.8f %.8f %.8f %.8f", bronze, silver, gold, platinum, diamond);
	}

}
