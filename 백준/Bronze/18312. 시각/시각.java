import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		String K = st.nextToken();
		
		int cnt = 0;
		for(int h=0; h<=N; h++) {
			String hour = h < 10 ? "0"+h : Integer.toString(h);
			if( hour.indexOf(K) < 0 ) {
				for(int m=0; m<=59; m++) {
					String min = m < 10 ? "0"+m : Integer.toString(m);
					if( min.indexOf(K) < 0 ) {
						for(int s=0; s<=59; s++) {
							String sec = s < 10 ? "0"+s : Integer.toString(s);
							if( sec.indexOf(K) < 0 ) cnt++;
						}
					}
				}
			}
		}
		System.out.println((N+1)*60*60-cnt);
	}	
}
