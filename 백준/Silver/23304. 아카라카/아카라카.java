import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static String str;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		str = br.readLine();
		int len = str.length();
		
		System.out.println(isPalin(0, len-1, len) ? "AKARAKA" : "IPSELENTI");
	}

	public static boolean isPalin(int s, int e, int len) {
		if( len == 1 ) return true;
		
		// 팰린드롬 확인
		for(int i=s; i<=len/2; i++) {
			if( str.charAt(i) != str.charAt(e-i) ) {
				return false;
			}
		}
		
		// 현재 문자가 팰린드롬이라면, 접두사/접미사도 팰린드롬인지 확인
		return isPalin(s, s+len/2-1, len/2) && isPalin(len/2, e, len/2);
	}
}
