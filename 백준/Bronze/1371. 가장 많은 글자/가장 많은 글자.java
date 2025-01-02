import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = "";
		int arr[] = new int[26];			// 알파벳 개수 저장되는 배열
		
		// 알파벳 개수 세기
		while( (str=br.readLine()) != null ) {
			
			for(int i=0; i<str.length(); i++) {
				if( str.charAt(i) != 32 )
					arr[str.charAt(i)-97] += 1;
			}
		}
		
		// 알파벳 최대 개수 구하기
		int max = 0;
		for( int a : arr ) {
			max = Math.max(max, a);
		}
		
		// 최대개수인 알파벳 출력
		for(int i=0; i<26; i++) {
			if( arr[i] == max ) 
				System.out.printf("%c", i+97);
		}
	}

}
