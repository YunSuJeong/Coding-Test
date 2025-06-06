import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 1000까지 제곱근 미리 구해놓기
		int[] arr = new int[1001];
		for(int i=1; i<=1000; i++) {
			if( i * i <= 1000 ) arr[i*i] = i;
		}
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			int cnt = 0;
			for(int i=A; i<=B; i++) {
				if( arr[i] > 0 ) {
					if( isPalin(i) && isPalin(arr[i]) ) cnt++;
				}
			}
		
			System.out.printf("#%d %d\n", tc, cnt);
		}
	}
	
	public static boolean isPalin(int n) {
		boolean flag = false;
		
		int ori = n, palin = 0;
		while( n > 0 ) {
			palin *= 10;
			palin += n % 10;
			
			n /= 10;
		}
		
		if( ori == palin ) flag = true;
		return flag;
	}

}
