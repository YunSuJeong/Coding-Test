import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		StringTokenizer page = new StringTokenizer(br.readLine());
		
		boolean[] arr = new boolean[N+1];			// 존재하는 페이지 T/F
		for(int i=0; i<M; i++) {
			arr[Integer.parseInt(page.nextToken())] = true;
		}
		
		// 누락된 페이지
		List<Integer> missing = new ArrayList<Integer>();
		for(int i=1; i<=N; i++) {
			if( !arr[i] ) missing.add(i);
		}

		int len = missing.size();
		int[] dp = new int[len];
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		for(int i=0; i<len; i++) {
			// 모든 누락된 페이지의 연속된 범위 탐색
			for(int j=0; j<=i; j++) {
				if( j == 0 ) {
					dp[i] = Math.min(dp[i], 5 + 2 * (missing.get(i)-missing.get(j)+1));
				} else {
					dp[i] = Math.min(dp[i], dp[j-1] + 5 + 2 * (missing.get(i)-missing.get(j)+1));
				}
			}
		}
		System.out.println(len == 0 ? 0 : dp[len-1]);
	}

}
