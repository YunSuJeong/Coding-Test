import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		oddCounting(N, 0);
		
		System.out.println(min+" "+max);
	}

	public static void oddCounting(int N, int cnt) {
		// 홀수 개수 카운팅
		int num = N, digit = 0;
		while( num > 0 ) {
			digit++;
			if( (num % 10) % 2 > 0 ) cnt++;
			num /= 10;
		}
		
		// 자릿수 별 분할
		if( N < 10 ) {
			min = Math.min(min, cnt);
			max = Math.max(max, cnt);
			return;
		} else if( N < 100 ) {
			oddCounting(N / 10 + N % 10, cnt);
		} else {
			String strN = Integer.toString(N);
			for(int i=1; i<strN.length()-1; i++) {
				for(int j=i+1; j<strN.length(); j++) {
					N = Integer.parseInt(strN.substring(0, i)) + Integer.parseInt(strN.substring(i, j)) + Integer.parseInt(strN.substring(j, strN.length()));
					oddCounting(N, cnt);
				}
			}
		}
	}
}
