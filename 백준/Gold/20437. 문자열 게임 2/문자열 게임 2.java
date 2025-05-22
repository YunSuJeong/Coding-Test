import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			String W = br.readLine();
			int K = Integer.parseInt(br.readLine());
			
			int[] alpha = new int[26];
			for(int i=0; i<W.length(); i++) {
				alpha[W.charAt(i)-97]++;
			}
			
			boolean flag = false;
			int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
			for(int i=0; i<26; i++) {
				if( alpha[i] >= K ) {
					flag = true;
					char c = (char)(i + 97);
					int s = W.indexOf(c);
					int e = s;
					int cnt = 1;
					while( e < W.length() && s < W.length() ) {
						if( cnt < K ) {
							e++;
							if( e >= W.length() ) break;
							if( W.charAt(e) == c ) cnt++;
						} else if( cnt == K ) {
							min = Math.min(min, e-s+1);
							if( W.charAt(e) == c && W.charAt(s) == c ) max = Math.max(max, e-s+1);
							if( W.charAt(s) == c ) cnt--;
							s++;
						}
					}
				}
			}
			
			if( flag ) sb.append(min+" "+max+"\n");
			else sb.append(-1+"\n");
		}
		System.out.println(sb.toString());
	}

}
