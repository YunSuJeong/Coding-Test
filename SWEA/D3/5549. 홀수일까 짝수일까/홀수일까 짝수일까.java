import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			// 100자리 양의 정수라 string으로 입력받기
			String str = br.readLine();
			
			// 마지막 자리가 짝수면 짝수임
			int num = str.charAt(str.length()-1)-'0';
			System.out.printf("#%d %s\n", tc, num % 2 == 0 ? "Even" : "Odd");
		}
	}

}
