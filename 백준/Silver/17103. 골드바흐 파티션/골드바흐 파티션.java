import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		boolean prime[] = new boolean[1000001];				// false = 소수
		
		for(int i=2; i<=1000000; i++) {
			if( prime[i] == false ) {
				for(int j=i*2; j<=1000000; j+=i) {			// 배수 지우기
					prime[j] = true;
				}
			}
		}
		
		for(int i=0; i<T; i++) {
			int n = Integer.parseInt(br.readLine());
			 
			int cnt = 0;
			 
			// 2) 에라토스테네스의 체
			for(int j=2; j<=n/2; j++) {
				if( prime[j] == false && prime[n-j] == false ) cnt++; 
			}
			  
			System.out.println(cnt);
		 }
	}

}
