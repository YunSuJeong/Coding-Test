import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		
		String A = st.nextToken(); 
		String B = st.nextToken(); 
		
		int cnt = 0;
		if( A.length() != B.length() ) {
			int min = A.length();
			for(int i=0; i<B.length()-A.length()+1; i++) {
				int diff = 0;
				// 가장 최소로 틀린 개수 구하기
				for(int j=0; j<A.length(); j++) {
					if( A.charAt(j) != B.charAt(i+j) ) diff++;
				}
				min = Math.min(min, diff);
			}
			cnt = min;
		} else {
			for(int i=0; i<A.length(); i++) {
				if( A.charAt(i) != B.charAt(i) ) cnt++;
			}
		}
		
		System.out.println(cnt);
	}

}
