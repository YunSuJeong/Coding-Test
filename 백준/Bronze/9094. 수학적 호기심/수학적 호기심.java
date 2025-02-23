import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			int cnt = 0;
			for(int i=1; i<n; i++) {
				for(int j=1; j<i; j++) {
					if( j < i ) {
						int num1 = i*i + j*j + m;
						int num2 = i * j;
						
						if( num1 % num2 == 0 ) cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
	}

}
