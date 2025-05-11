import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		int len = str.length();
		
		int[] arr = new int[len];
		for(int i=0; i<len; i++) {
			arr[i] = str.charAt(i) >= 'A' && str.charAt(i) <= 'Z' ? 1 : 0;
		}
		
		int min = len;
		int activate = 0;				// 현재 활성화 여부 : 0 - 소문자, 1 - 대문자
		for(int i=0; i<len; i++) {
			if( activate == 0 ) {		// 활성화 여부가 소문자일 때,
				if( arr[i] == 1 ) {		// 현재 문자가 대문자라면
					min++;				// (별 or 마름모) 연산 1회 시행
					if( i + 1 < len && arr[i+1] == 1 ) activate = 1;		// 마름모 연산 시행될 조건 : 다음 문자가 대문자일 때
				}
			} else {					// 활성화 여부가 대문자 일 때,
				if( arr[i] == 0 ) {		// 현재 문자가 소문자라면,
					min++;				// (별 or 마름모) 연산 1회 시행
					if( i + 1 < len && arr[i+1] == 0 ) activate = 0;		// 마름모 연산 시행될 조건 : 다음 문자가 소문자일 때
				}
			}
		}
		System.out.println(min);
	}

}
