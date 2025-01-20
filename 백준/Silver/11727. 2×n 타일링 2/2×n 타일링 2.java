import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static long[][] comb; // 메모이제이션 배열

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		// 1. 시간초과
//		long sum = 1, pow = 1;
//		for(int i=1; i<=N/2; i++) {
//			pow = pow * 2 % 10007;
//			sum = sum + combination(N-i, i) % 10007 * pow;
//		}
//		System.out.println(sum%10007);
		
		// 2. 조합 계산 -> 메모제이션 방식으로 변경
		comb = new long[N + 1][N + 1]; // 조합 저장 배열 초기화
        long sum = 1, pow = 1;

        for (int i = 1; i <= N / 2; i++) {
            pow = pow * 2 % 10007; // 2^i 값 계산
            sum = sum + combination(N - i, i) % 10007 * pow % 10007; // 조합과 pow 계산
        }
        System.out.println(sum % 10007);
	}
	
//	public static long combination(int n, int r) {
//		if( n == r || r == 0 ) return 1;
//		else return combination(n-1, r-1) + combination(n-1, r);
//	}
	
	public static long combination(int n, int r) {
        if (n == r || r == 0) return 1;
        if (comb[n][r] != 0) return comb[n][r]; 
        return comb[n][r] = (combination(n - 1, r - 1) + combination(n - 1, r)) % 10007;
    }

}
