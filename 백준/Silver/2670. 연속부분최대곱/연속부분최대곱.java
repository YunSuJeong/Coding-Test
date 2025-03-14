import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {
	
	public static int N;
	public static double max = 0.0;
	public static double[] arr;
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
//		arr = new double[N];
//		for(int i=0; i<N; i++) {
//			double num = Double.parseDouble(br.readLine());
//			arr[i] = num;
//		}
		
		// 1. 모든 구간 곱 다 구하기 -> 시간 초과
//		multiMax(0);
//		System.out.println(Math.round(max*1000)/1000.0);
		
		
		// 2. dp : double형으로는 부동 소수점 오차로 인해 소수계산이 제대로 이뤄지지 않음
//		double[] dp = new double[N];
//		dp[0] = arr[0];
//		max = dp[0];
//		for(int i=1; i<N; i++) {
//			dp[i] = Math.max(arr[i], dp[i - 1] * arr[i]);
//			max = Math.max(max, dp[i]);
//		}
//		System.out.println(Math.round(max*1000)/1000.0);
//		System.out.printf("%.3f\n", max);
		
		// 3. BigDecimal 이용
		BigDecimal[] arr = new BigDecimal[N];

        // 입력을 BigDecimal로 변환하여 저장
        for (int i = 0; i < N; i++) {
            arr[i] = BigDecimal.valueOf(Double.parseDouble(br.readLine()));
        }

        BigDecimal[] dp = new BigDecimal[N];
        dp[0] = arr[0];
        BigDecimal max = dp[0];

        for (int i = 1; i < N; i++) {
            dp[i] = arr[i].max(dp[i - 1].multiply(arr[i])); // arr[i]와 dp[i-1] * arr[i] 중 큰 값 선택
            max = max.max(dp[i]); // 최대값 갱신
        }

        // 정확한 반올림 (소수 셋째 자리까지)
        max = max.setScale(3, RoundingMode.HALF_UP);
        System.out.println(max);
	}
	
	/*public static void multiMax(int idx) {
		if( idx >= N ) return;
		
		// 현재까지 모든 연속구간의 곱 계산하여 최댓값 갱신
		for(int i=0; i<=idx; i++) {
			max = Math.max(max, multi(i, idx));
		}
		multiMax(idx+1);
	}
	
	// 연속된 구간의 곱 구하기
	public static double multi(int start, int end) {
		double num = 1.0;
		for(int i=start; i<=end; i++) {
			num *= arr[i];
		}
		return num;
	}*/

}
