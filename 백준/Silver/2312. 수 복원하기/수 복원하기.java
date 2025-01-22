import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		// 100000이하 소수 구하기
		boolean prime[] = new boolean[100001];
		for(int i=2; i*i<=100000; i++) {
			for(int j=i*i; j<=100000; j+=i) {
				if( prime[j] == false ) prime[j] = true;
			}
		}
		for(int tc=0; tc<T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			int num = N;
			for(int i=2; i<=N; i++) {
				int pow = 0;
				if( prime[i] == false ) {
					while( true ) {
						if( num % i > 0 ) break; 
						
						num /= i;
						pow++;
					} 
					if( pow > 0 ) sb.append(i+" "+pow+"\n");
				}
			}
		}
		System.out.println(sb.toString());
	}

}
