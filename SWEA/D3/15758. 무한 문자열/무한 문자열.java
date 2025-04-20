import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			String str1 = st.nextToken();
			String str2 = st.nextToken();
			
			int gcd = gcd(str1.length(), str2.length());;
			int lcm = gcd * (str1.length()/gcd) * (str2.length()/gcd);
			
			for(int i=0; i<lcm/str1.length(); i++) {
				sb.append(str1);
			}
			str1 = sb.toString();
			sb.setLength(0);

			for(int i=0; i<lcm/str2.length(); i++) {
				sb.append(str2);
			}
			str2 = sb.toString();
			sb.setLength(0);
			
			System.out.printf("#%d %s\n", tc, str1.equals(str2) ? "yes" : "no");
		}
	}
	
	public static int gcd(int a, int b) {
		if( b == 0 ) return a;
		else return gcd(b, a%b);
	}

}
