import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			
			int N = Integer.parseInt(br.readLine());
			
			Stack<Integer> stack = new Stack<Integer>();
			for(int i=0; i<N; i++) {
				int num = Integer.parseInt(br.readLine());
				
				if( num == 0 ) {
					stack.pop();
				} else {
					stack.push(num);
				}
			}
			
			long sum = 0 ;
			for(int n : stack) {
				sum += n;
			}
			
			System.out.printf("#%d %d\n", tc, sum);
		}
	}

}
