import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			long N = Long.parseLong(st.nextToken());
			long A = Long.parseLong(st.nextToken());
			long B = Long.parseLong(st.nextToken());
			
			long min = Long.MAX_VALUE;
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N/i; j++) {
					min = Math.min(min, A * Math.abs(i-j) + B * (N - i * j));
				}
			}
			sb.append("#"+tc+" "+min+"\n");
		}
		System.out.println(sb.toString());
	}

}
