import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int prime[] = new int[100001];			// 100,000까지 소수
		prime[0] = 1;
		prime[1] = 1;
		for(int i=2; i<=100000; i++) {
			for(int j=i; j<=100000; j+=i) {
				if( j == i && prime[i] != 1 ) prime[j] = 0;
				else prime[j] = 1;
			}
		}
		
		// A~B 언더프라임 개수 구하기
		int underPrimeCnt = 0;
		for(int i=A; i<=B; i++) {
			
			// 소수 개수 구하기
			int idx = 2, num = i;
			int cnt = 0;
			while(true) {
				if( num <= 1 ) break;
				
				if( prime[idx] > 0 || num % idx > 0 ) {
					idx++; 
					continue;
				}
				
				num /= idx;
				cnt++;
			}
			
			// 언더프라임 인지 체크
			if( prime[cnt] == 0 ) underPrimeCnt++;
		}
		System.out.println(underPrimeCnt);
	}
}
