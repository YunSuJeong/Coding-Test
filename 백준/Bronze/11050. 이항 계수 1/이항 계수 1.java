import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int nk = binomial(N, K);
		System.out.println(nk);
	}
	
	// 이항계수 구하는 재귀함수
	public static int binomial(int n, int k) {
		if( k == 0 || k == n ) {
			return 1;
		} else {
			return binomial(n-1, k-1) + binomial(n-1, k);			// 이항계수의 점화식
		}
	}

}
