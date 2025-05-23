import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1; tc<=10; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			String str = st.nextToken();
			
			while( true ) {
				boolean flag = false;
				
				for(int i=0; i<str.length()-1; i++) {
					if( str.charAt(i) == str.charAt(i+1) ) {
						str = str.replace(str.subSequence(i, i+2), "");
						flag = true;
						break;
					}
				}
				
				if( !flag ) break;
			}
			System.out.printf("#%d %s\n", tc, str);
		}
 	}

}
