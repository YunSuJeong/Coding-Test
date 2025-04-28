import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			String str = br.readLine();
			
			Stack<Character> stack = new Stack<Character>();
			int cnt = 0;
			for(int i=0; i<str.length(); i++) {
				char c = str.charAt(i);
				if( c == '(' ) {
					stack.push(c);
				} else if( c == ')' ) {
					if( stack.isEmpty() ) cnt++;
					else if( stack.peek() == '(' ) {
						stack.pop();
						cnt++;
					} else {
						cnt++;
					}
				} else if( c == '|' ) {
					if( !stack.isEmpty() && stack.peek() == '(' ) {
						stack.pop();
						cnt++;
					} 
				}
			}
			System.out.printf("#%d %d\n", tc, cnt);
		}
	}

}
