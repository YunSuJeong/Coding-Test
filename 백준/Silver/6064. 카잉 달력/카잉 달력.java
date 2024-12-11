import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			String str = br.readLine();
			
			StringTokenizer st = new StringTokenizer(str);
			
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			
			int cx = x % M;
			int cy = y % N;
			
			// 1) 시간초과
//			int kYear = 1;
//			while( true ) {
//				// 카잉 달력의 마지막 해 <M:N>일 때, k = M, N의 최소공배수
//				int lcm = M * N / gcd(M, N);
//				if( kYear > lcm ) {
//					kYear = -1;
//					break;
//				}
//
//				if( kYear % M == cx && kYear % N == cy ) break;
//				
//				kYear++;
//			}
			
			// 2) 나머지 연산 이용하여 반복횟수 줄이기
			int kYear = x;
			int lcm = M * N / gcd(M, N);
			int i = 0;

			while( true ) {
				if( kYear > lcm ) {
					kYear = -1;
					break;
				}
				
				if( kYear % N == cy ) break;
				
				i++;
				kYear = M * i + x;
			}
			
			
			System.out.println(kYear);
		}
	}
	
	// 최대공약수 구하기
	public static int gcd(int a, int b) {
		if( b == 0 ) return a;
		else return gcd(b, a%b);
	}

}
