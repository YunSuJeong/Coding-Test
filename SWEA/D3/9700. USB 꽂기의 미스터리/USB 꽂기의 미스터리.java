import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			double p = Double.parseDouble(st.nextToken());
			double q = Double.parseDouble(st.nextToken());
			
			String result = "NO";
			// s1 = (1-p) * q		: 처음에 올바르지 못한 면으로 꽂아 뒤집어서 정상적으로 꽂힌 경우
			// s2 = p * (1-q) * q	: 처음에 올바르게 꽂았으나 정상적으로 꽂히지 않아 뒤집고, 올바르지 못한면이어서 다시 뒤집은 다음 정상적으로 꽂힌 경우
			if( 1-p < p * (1-q) ) result = "YES";
			
			System.out.printf("#%d %s\n", tc, result);
		}
	}

}
