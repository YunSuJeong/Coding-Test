import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		
		int len = str.length();
		int arr[] = new int[26];
		for(int i=0; i<len; i++) {
			arr[str.charAt(i)-65] += 1;
		}
		
		// 팰린드롬이 가능한 문자인지 확인
		boolean isPalin = true;
		int oddCnt = 0, oddIdx = 0;
		for(int i=0; i<26; i++) {
			if( arr[i] % 2 == 1 ) {
				oddCnt++;
				oddIdx = i;
			}
		}
		
		if( (len % 2 == 0 && oddCnt > 0) || (len % 2 == 1 && oddCnt > 1) ) {
			// 문자열의 길이가 짝수이면서 알파벳의 개수가 홀수인 것이 1개라도 있거나
			// 문자열 길이가 홀수이면서알파벳의 개수가 홀수인 것이 1개보다 많을 때는 팰린드롬이 될 수 없음
			System.out.println("I'm Sorry Hansoo");
		} else {
			// 사전순으로 가장 앞서는 팰린드롬 만들기
			for(int i=0; i<26; i++) {
				for(int j=0; j<arr[i]/2; j++) {
					sb.append((char)(i+65));
				}
			}
			if( len % 2 == 1 ) sb.append((char)(oddIdx+65));
			for(int i=25; i>=0; i--) {
				for(int j=0; j<arr[i]/2; j++) {
					sb.append((char)(i+65));
				}
			}
			System.out.println(sb.toString());
		}
	}

}
