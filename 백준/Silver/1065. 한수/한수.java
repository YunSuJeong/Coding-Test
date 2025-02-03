import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		if( N < 100 ) {
			System.out.println(N);
		} else {
			int cnt = 99;

			// 한수인지 확인
			for(int i=100; i<=N; i++) {
				String num = Integer.toString(i);
				int diff = num.charAt(0)-num.charAt(1)-'0', flag = 0;
				for(int j=1; j<num.length()-1; j++) {
					if( diff != num.charAt(j)-num.charAt(j+1)-'0' ) {
						flag = 1;
						break;
					}
				}
				if( flag == 0 ) cnt++;
			}
			
			System.out.println(cnt);
		}
	}

}
