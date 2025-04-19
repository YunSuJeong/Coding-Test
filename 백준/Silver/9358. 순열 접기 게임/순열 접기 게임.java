import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int[] arr = new int[N];
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			while( true ) {
				if( N == 2 ) break;
				
				for(int i=0; i<=N/2; i++) {
					arr[i] += arr[N-1-i];
				} 
				
				N = (int) Math.ceil(N/2.0);
			}
			
			String win = arr[0] > arr[1] ? "Alice" : "Bob";
			sb.append("Case #"+tc+": "+win+"\n");
		}
		System.out.println(sb.toString());
	}

}
