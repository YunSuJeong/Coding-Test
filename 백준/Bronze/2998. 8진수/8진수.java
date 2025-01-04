import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		
		int i = str.length()-1;
		int cycle = 0, sum = 0;
		Stack<Integer> stack = new Stack<Integer>();
		while( true ) {
			
			if( i < 0 ) break;
			
			sum += (str.charAt(i)-'0') * Math.pow(2, cycle);
			cycle++;
			if( cycle == 3 || i == 0 ) {
				stack.push(sum);
				cycle = 0;
				sum = 0;
			}
			
			i--;
		}
		
		while( !stack.empty() ) {
			System.out.print(stack.pop());
		}
	}

}
