import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long[] cube = new long[1000001];
		for(int i=1; i<=1000000; i++) {
            // i가 int형이기 때문에 cube가 long형이어도 오버플로우로 인하여 제대로 계산되지 않음
			cube[i] = (long)i * i * i;
		}

        int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			long N = Long.parseLong(br.readLine());
			
			int X = -1;
			for(int i=1; i<=1000000; i++) {
				if( cube[i] == N ) {
					X = i;
					break;
				} else if( cube[i] > N ) {
					break;
				}
			}
			System.out.printf("#%d %d\n", tc, X);
		}
	}

}
