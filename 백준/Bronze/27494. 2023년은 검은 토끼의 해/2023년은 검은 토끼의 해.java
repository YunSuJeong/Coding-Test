import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		char win[] = {'2', '0', '2', '3'};
		
		// 4자리수 이상인지 체크
		if( N >= 2023 ) {
			for(int i=2023; i<=N; i++) {
				
				String num = Integer.toString(i);
				int len = num.length();
				
				int k = 0;
				for(int j=0; j<len; j++) {
					if( win[k] == num.charAt(j) ) {
						k++;
					}
					
					if( k == 4 ) break;
				}
				if( k == 4 ) cnt++;
			}
		}
		System.out.println(cnt);
	}

}
