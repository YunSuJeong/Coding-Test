import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		Stack<Integer> stack = new Stack<Integer>();
		while( (str=br.readLine()) != null ) {
			
			if( str.equals("고무오리 디버깅 끝") ) break;
			
			if( str.equals("문제") ) stack.push(1);
			else {
				if( stack.isEmpty() ) {
					stack.push(1);
					stack.push(1);
				} else {
					stack.pop();
				}
			}
		}
		
		if( stack.isEmpty() ) System.out.println("고무오리야 사랑해");
		else System.out.println("힝구");
	}

}
