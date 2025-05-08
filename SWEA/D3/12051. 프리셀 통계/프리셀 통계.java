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
			
			long N = Long.parseLong(st.nextToken());
			int pd = Integer.parseInt(st.nextToken());
			int pg = Integer.parseInt(st.nextToken());
			
			boolean flag = true;
			if( pg == 100 || pg == 0 ) {
				// pg가 100% 또는 0%일때는 pd또한 100%, 0%여야지만 가능함
				if( pg != pd ) flag = false;
			} else {
				// 그 외 1~99%는 G는 값을 모르기 때문에(= 어떠한 값도 올 수 있다.), pd만 가능하다면 pg는 가능하다.
				flag = false;
				for(int i=1; i<=N; i++) {
					if( i * pd % 100 == 0 ) {
						flag = true;
						break;
					}
				}
			}
			System.out.printf("#%d %s\n", tc, flag ? "Possible" : "Broken");
		}
	}

}
