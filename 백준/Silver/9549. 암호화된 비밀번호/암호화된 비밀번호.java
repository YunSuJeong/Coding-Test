import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<T; tc++) {
			char[] enc = br.readLine().toCharArray();
			char[] dec = br.readLine().toCharArray();
			
			// 암호화 전 pw 알파벳 조합 저장
			int[] decCnt = new int[26];
			int[] encCnt = new int[26];
			for(int i=0; i<dec.length; i++) {
				decCnt[dec[i]-97]++;
			}
			
			// 슬라이딩 윈도우로 탐색하며 같은 알파벳 조합이 존재하는지 체크
			boolean flag = true;
			for(int i=0; i<enc.length; i++) {
				flag = true;
				if( i < dec.length ) 
					encCnt[enc[i]-97]++;
				else {
					encCnt[enc[i-dec.length]-97]--;
					encCnt[enc[i]-97]++;
				}
				
				for(int j=0; j<26; j++) {
					if( encCnt[j] != decCnt[j] ) {
						flag = false;
						break;
					}
				}
				if( flag ) break;
			}
			
			if( flag ) sb.append("YES\n");
			else sb.append("NO\n");
		}
		System.out.println(sb.toString());
	}

}
