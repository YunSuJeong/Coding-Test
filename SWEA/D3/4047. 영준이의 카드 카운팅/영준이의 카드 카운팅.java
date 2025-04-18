import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			String str = br.readLine();
			
			int S, D, H, C;
			S = D = H = C = 13;
			
			boolean flag = true;
			Set<String> set = new HashSet<String>();
			for(int i=0; i<str.length()/3; i++) {
				String s = str.substring(i*3, i*3+3);
				
				if( set.contains(s) ) {
					flag = false;
					break;
				} else {
					set.add(s);
					
					char type = s.charAt(0);
					switch (type) {
					case 'S':
						S--;
						break;
					case 'D':
						D--;
						break;
					case 'H':
						H--;
						break;
					case 'C':
						C--;
						break;
					}
				}
			}
			
			if( !flag ) {
				sb.append("ERROR");
			} else {
				sb.append(S+" "+D+" "+H+" "+C);
			}
			System.out.printf("#%d %s\n", tc, sb.toString());
			sb.setLength(0);
		}
	}

}
