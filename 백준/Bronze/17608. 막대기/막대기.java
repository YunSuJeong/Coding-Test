import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<Integer>();
		for(int i=0; i<N; i++) {
			stack.push(Integer.parseInt(br.readLine()));
		}
		
		int right = stack.pop();
		int cnt = 0;
		for(int i=0; i<N-1; i++) {
			if( stack.peek() > right ) { 
				cnt++; 
				right = stack.peek();
			}
			stack.pop();
		}
		System.out.println(cnt+1);
	}

}
