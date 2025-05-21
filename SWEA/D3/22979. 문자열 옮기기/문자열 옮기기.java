import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			String str = br.readLine();
			int K = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			Deque<String> deque = new ArrayDeque<String>();
			for(String s : str.split("")) deque.offer(s);
			
			for(int i=0; i<K; i++) {
				int X = Integer.parseInt(st.nextToken());
				
				if( X != 0 ) {
					int len = Math.abs(X) % str.length();
					for(int j=0; j<len; j++) {
						if( X > 0 ) 
							deque.offer(deque.poll());
						else
							deque.offerFirst(deque.pollLast());
					}
				}
			}
			
			for(int i=0; i<str.length(); i++) {
				sb.append(deque.poll());
			}
			System.out.printf("%s\n", sb.toString());
			sb.setLength(0);
		}
	}

}
