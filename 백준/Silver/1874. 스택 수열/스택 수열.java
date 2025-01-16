import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Stack<Integer> stack = new Stack<Integer>();
		
		int next = 1;
		for(int i=0; i<n; i++) {
			if( !stack.isEmpty() && stack.peek() > arr[i] ) {
				System.out.println("NO");
				break;
			}
			while( stack.isEmpty() || next <= arr[i] ) {
				stack.push(next);
				next++;
				sb.append("+\n");
			}
			stack.pop();
			sb.append("-\n");
		}
		if(stack.isEmpty()) System.out.println(sb.toString());
		
		// 시간초과
//		int next = 1, curr = 0;
//		while( curr < n ) {
//			if( next > n && stack.peek() != arr[curr] ) break;
//			if( stack.isEmpty() || next <= arr[curr] ) {
//				stack.push(next);
//				sb.append("+\n");
//				next++;
//			} else if( stack.peek() == arr[curr] ) {
//				stack.pop();
//				sb.append("-\n");
//				curr++;
//			}
//		}
//		if( stack.isEmpty() ) System.out.println(sb.toString());
//		else System.out.println("NO");
	}

}
