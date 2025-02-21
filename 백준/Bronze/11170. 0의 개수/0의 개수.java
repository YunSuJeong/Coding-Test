import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int cnt = N == 0 ? 1 : 0;
			for(int i=N; i<=M; i++) {
				int num = i;
				while( num / 10 > 0 ) {
					if( num % 10 == 0 ) cnt++;
					num /= 10;
				}
			}
			sb.append(cnt+"\n");
		}
		System.out.println(sb.toString());
	}

}
