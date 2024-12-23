import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		String arr[] = br.readLine().split(" ");
		
		// 현재 줄 서 있는 순서
		Stack<Integer> stack = new Stack<Integer>();
		for(int i=N-1; i>=0; i--) {
			stack.push(Integer.parseInt(arr[i]));
		}
		
		int snack = 0;									// 마지막으로 간식 받은 번호
		Stack<Integer> tmp = new Stack<Integer>();		// 한 명씩만 설 수 있는 공간
		
		String result = "Sad";
		while( true ) {
			if( snack == N ) {
				result = "Nice";
				break;
			}
			if( stack.empty() && snack+1 != tmp.peek() ) break;
			
			if( !stack.empty() && snack+1 == stack.peek() ) {
				stack.pop();
				snack++;
			} else if( !tmp.empty() && snack+1 == tmp.peek() ) {
				tmp.pop();
				snack++;
			} else {
				tmp.push(stack.pop());
			}
		}
		bw.write(result);
		bw.flush();
		bw.close();
	}

}
