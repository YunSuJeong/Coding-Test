import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		
		int len = str.length();
		
		if( isPlain(str) ) {
			System.out.println(len);
		} else {
			int cnt = len - 1, idx = 0;
			while( true ) {
				sb.append(str.charAt(cnt));
				int i = str.lastIndexOf(sb.toString());
				if( i < 0 ) break;
				
				String tmp = str.substring(i);
				if( !isPlain(tmp) ) break;
				cnt--;
				idx = i;
			}
			System.out.println(len+idx);
		}
	}
	
	// 팰린드롬인지 체크
	public static boolean isPlain(String str) {
		boolean isPalin = true;
		for(int i=0; i<str.length()/2; i++) {
			if( str.charAt(i) != str.charAt(str.length()-1-i) ) {
				isPalin = false;
				break;
			}
		}
		return isPalin;
	}
}
