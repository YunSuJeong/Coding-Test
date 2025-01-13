import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int cnt1 = 0, cnt2 = 0;
		for(int i=N; i>=1; i--) {
			int num = i;
			while( true ) {
				if( num <= 0 || (num % 2 != 0 && num % 5 != 0) ) break;
				
				if( num % 2 == 0 ) {
					cnt1++;
					num /= 2;
				}
				if( num % 5 == 0 ) {
					cnt2++;
					num /= 5;
				}
			}
		}
		System.out.println(cnt1 > cnt2 ? cnt2 : cnt1);
	}

}
