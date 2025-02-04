import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int cnt1 = 0, cnt2 = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		// 재귀호출
		fib(N);
		
		// DP
		int arr[] = new int[N+1];
		arr[1] = 1;
		arr[2] = 1;
	    for (int i=3; i<=N; i++) {
	    	cnt2++;
	    	arr[i] = arr[i-1] + arr[i-2];			// 코드2
	    }
	    
	    System.out.printf("%d %d", cnt1, cnt2);
	}
	
	public static int fib(int n) {
	    if (n == 1 || n == 2) {
	    	cnt1++;
	    	return 1;  								// 코드1
	    } else {
	    	return (fib(n - 1) + fib(n - 2));
	    }
	}
}
