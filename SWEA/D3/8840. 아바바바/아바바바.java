import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			int L = Integer.parseInt(br.readLine());
			
			// 등차수열의 합공식 이용
			long cnt = L / 2;
			long sum = cnt * cnt;
			sb.append("#"+tc+" "+sum+"\n");
		}
		System.out.printf(sb.toString());
	}

}
