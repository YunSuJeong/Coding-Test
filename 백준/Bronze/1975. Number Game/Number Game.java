import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			int N = Integer.parseInt(br.readLine());
			
			// 진법 변환
			int cnt = 0;
			for(int j=2; j<=N; j++) {
				// 1. 16진수 때문에 NumberFormat 오류 나는 듯
//				int num = Integer.parseInt(Integer.toString(N, j));
//				int k = 0;				// 0의 개수
//				if( num % 10 == 0 ) {
//					k = 1;
//					while( true ) {
//						if( num % (int)Math.pow(10, k+1) == 0 ) k++;
//						else break;
//					}
//				}
//				cnt += k;
				
				// 2. 나눠서 나머지 0이면 바로 개수 카운팅
				int num = N;
				while( true ) {
					if( num / j == 0 ) break;
					if( num % j == 0 ) cnt++;
					else break;
					num /= j;
				}
				
			}
			sb.append(cnt+"\n");
		}
		System.out.println(sb.toString());
	}
	
}
