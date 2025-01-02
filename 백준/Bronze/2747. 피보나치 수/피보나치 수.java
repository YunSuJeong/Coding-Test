import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n+1];
        
        // 1. 재귀함수 -> 시간초과 
		//System.out.println(fibonacci(n));
		
		// 2. 반복문 이용
		arr[0] = 0;
		arr[1] = 1;
		for(int i=2; i<=n; i++) {
			arr[i] = arr[i-1] + arr[i-2];
		} 
		System.out.println(arr[n]);
	}
	
	/*public static int fibonacci(int n) {
		if( n == 0 ) {
			return 0;
		} else if( n == 1 ) {
			return 1;
		} else {
			return fibonacci(n-1) + fibonacci(n-2);
		}
	}*/
	
}
