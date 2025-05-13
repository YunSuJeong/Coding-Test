import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			String str = br.readLine();
			int len = str.length();
			
			boolean flag = true;
			for(int i=0; i<len/2; i++) {
                // 비교하려는 두 문자 중 ? 가 한개라도 있다면 팰린드롬으로 만들 수 있음
				if( str.charAt(i) == str.charAt(len-i-1) || (str.charAt(i) == '?' || str.charAt(len-i-1) == '?' ) ) {
					continue;
				} else {
					flag = false;
					break;
				}
			}
			System.out.printf("#%d %s\n", tc, flag ? "Exist" : "Not exist");
		}
	}

}
