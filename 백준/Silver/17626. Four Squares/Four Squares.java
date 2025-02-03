import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		// 1. 완전 탐색 틀림
//		int min = 50000;
//		for(int i=(int) Math.sqrt(N); i>=1; i--) {
//			int pow = i, cnt = 0, num = N;
//			while( true ) {
//				System.out.println(pow+" "+num);
//				if( pow == 0 || num == 0 ) {
//					System.out.println(cnt);
//					if( cnt > 0 ) min = Math.min(min, cnt);
//					break;
//				}
//				
//				if( num >= pow * pow ) {
//					num -= pow*pow;
//					cnt++;
//				}
//				
//				if( num < pow * pow ) pow--;
//			}
//		}
//		System.out.println(min);
		
		// 2. DP
		int arr[] = new int[N+1];
		
		// 제곱수 = 1
		for(int i=2; i<=Math.sqrt(N); i++) {
			arr[i*i] = 1;
		}
		
		// 나머지 수들 구하기
		for(int i=1; i<=N; i++) {
			if( i < 3 ) arr[i] = i;
			else {
				for(int j=(int) Math.sqrt(i); j>=1; j--) {
					arr[i] = arr[i] == 0 ? arr[j*j] + arr[i-j*j] : Math.min(arr[i], arr[j*j] + arr[i-j*j]);
				}
			}
		}
		System.out.println(arr[N]);
	}

}
