import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		boolean[] prime = new boolean[1000001];
		prime[1] = true;
		for(int i=2; i*i<=1000000; i++) {
			if( !prime[i] ) {
				for(int j=i*2; j<=1000000; j+=i) {
					prime[j] = true;
				}
			}
		}
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int D = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			int cnt = 0;
			for(int i=A; i<=B; i++) {
				boolean flag = false;
				if( !prime[i] ) {
					int num = i;
					int remain = 0;
					while( num > 0 ) {
						remain = num % 10;
						
						if( remain == D ) {
							flag = true;
							break;
						}
						
						num /= 10;
					}
				}
				if( flag ) cnt++;
			}
			System.out.printf("#%d %d\n", tc, cnt);
		}
	}

}
