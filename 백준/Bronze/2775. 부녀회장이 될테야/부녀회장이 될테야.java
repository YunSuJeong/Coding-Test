import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			
			// 1. 재귀 (400ms)
			//System.out.println(recursion(k, n));
			
			// 2. DP 2차원 배열로 풀어보기
			int arr[][] = new int[k+1][n+1];
			for(int i=0; i<=k; i++) {
				for(int j=0; j<=n; j++) {
					if( i == 0 || j == 1 ) arr[i][j] = j;
					
					if( j > 0 && i > 0 ) {
						arr[i][j] = arr[i-1][j] + arr[i][j-1];
					}
				}
			}
			System.out.println(arr[k][n]);
		}
	}
	
	/*public static int recursion(int k, int n) {
		int sum = 0;
		if( k <= 0 ) {
			return n;
		} else {
			for(int i=1; i<=n; i++) {
				sum += recursion(k-1, i);
			}
			return sum;
		}
	}*/

}
