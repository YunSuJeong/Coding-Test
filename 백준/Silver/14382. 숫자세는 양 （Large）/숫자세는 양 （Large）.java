import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			boolean[] arr = new boolean[10];
			int i = 1, cnt = 0, num = N; 
			if( N == 0 ) {
				sb.append("Case #"+tc+": INSOMNIA\n");
			} else {
				while( cnt < 10 ) {
					num = N * i;
					
					// 기록되지 않은 문자들 기록하기
					int n = num;
					while( n > 0 ) {
						if( !arr[n%10] ) {
							cnt++;
							arr[n%10] = true;
						}
						n /= 10;
					}
					
					i++;
				}
				sb.append("Case #"+tc+": "+num+"\n");
			}
		}
		System.out.println(sb.toString());
	}

}
