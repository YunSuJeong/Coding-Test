import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str = "";
		BigDecimal[] dp = new BigDecimal[251];

		dp[0] = BigDecimal.ONE;
		dp[1] = BigDecimal.ONE;
		dp[2] = BigDecimal.valueOf(3);
		dp[3] = BigDecimal.valueOf(5);
		while( (str=br.readLine()) != null ) {
			int N = Integer.parseInt(str);
			for(int i=4; i<=N; i++) {
				dp[i] = dp[i-2].multiply(BigDecimal.valueOf(2)).add(dp[i-1]);
			}
			
			sb.append(dp[N]+"\n");
		}
		
		System.out.println(sb.toString());
	}

}
