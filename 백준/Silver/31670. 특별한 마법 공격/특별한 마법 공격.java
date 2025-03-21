import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		long[][] dp = new long[N][2];		// 현재 학생까지 필요한 최소 에너지
		for(int i=0; i<N; i++) {
			if( i == 0 ) {
				dp[i][0] = arr[0];			// 현재 학생 단죄 O
				dp[i][1] = 0;				// 현재 학생 단죄 X
			} else {
				dp[i][0] = Math.min(dp[i-1][0], dp[i-1][1]) + arr[i];			// i번째 학생을 단죄할 때, 필요한 최소 에너지 = 현재 학생의 저항력 + (이전 학생까지 단죄한 최소 에너지, 이전학생은 단죄하지 않은 최소 에너지)
				dp[i][1] = dp[i-1][0];											// 현재 학생을 단죄하지 않는 경우는 이전 학생까지 에너지를 그대로 가지면 됨
			}
		}
		
		System.out.println(Math.min(dp[N-1][0], dp[N-1][1]));
	}
}
