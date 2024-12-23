import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = "";
		while( (str=br.readLine()) != null ) {
			if( str.equals(".") ) break;
			
			Stack<String> stack = new Stack<String>();
			for(String s : str.split("")) {
				if( s.equals("(") || s.equals("[") ) stack.push(s);
				
				if( s.equals(")") ) {
					if( stack.empty() || !stack.peek().equals("(") ) {
						stack.push(s);
						break;
					}
					else stack.pop();
				}
				if( s.equals("]") ) {
					if( stack.empty() || !stack.peek().equals("[") ) {
						stack.push(s);
						break;
					}
					else stack.pop();
				}
			}
			
			if( stack.empty() ) bw.write("yes\n");
			else bw.write("no\n");
		}
		bw.flush();
		bw.close();
	}
}
