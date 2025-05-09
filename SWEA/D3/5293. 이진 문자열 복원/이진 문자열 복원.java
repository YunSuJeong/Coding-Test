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
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken());
			
			String result = "impossible";
			if( (A > 0 && B == 0 && C == 0 && D == 0) || (A == 0 && B == 0 && C == 0 && D > 0) ) {
				// A 또는 D만 있는 경우
				if( A > 0 ) {
					for(int i=0; i<A+1; i++) {
						sb.append("0");
					}
				} else {
					for(int i=0; i<D+1; i++) {
						sb.append("1");
					}
				}
				result = sb.toString();
			} else if( B == C && B > 0 && C > 0 ) {
				// B가 존재하면 C도 무조건 존재해야함 
				for(int i=0; i<A; i++) {
					sb.append("0");
				}
				for(int i=0; i<B; i++) {
					sb.append("01");
				}
				for(int i=0; i<D; i++) {
					sb.append("1");
				}
				sb.append("0");
				result = sb.toString();
			} else if( Math.abs(B-C) == 1) {
				// B,C의 차가 1이어야 가능함 -> A, D는 맨 앞이나 맨 뒤에 붙이면 되기때문에 신경쓰지 않아도 된다.
				// B,C의 차이가 2개이상부터는 붙일 수 없는 부분이 생김
                // ex) 01 10 10 10 -> 010 (=01+10) 10 10 -> 10 두개 남고
                //				   -> 1010 (=10+01+10) 10 -> 10 한개 남음
				if( B > C ) {
					for(int i=0; i<A; i++) {
						sb.append("0");
					}
					for(int i=0; i<B; i++) {
						sb.append("01");
					}
					for(int i=0; i<D; i++) {
						sb.append("1");
					}
				} else {	// B < C
					for(int i=0; i<D; i++) {
						sb.append("1");
					}
					for(int i=0; i<C; i++) {
						sb.append("10");
					}
					for(int i=0; i<A; i++) {
						sb.append("0");
					}
				}
				result = sb.toString();
			}
			System.out.printf("#%d %s\n", tc, result);
			sb.setLength(0);
		}
	}
	
}
