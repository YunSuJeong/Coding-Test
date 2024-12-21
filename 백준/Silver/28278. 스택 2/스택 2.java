import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<Integer>();
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			
			int cmd = Integer.parseInt(st.nextToken());

			switch (cmd) {
			case 1:
				stack.push(Integer.parseInt(st.nextToken()));
				break;
			case 2:
				if( stack.isEmpty() ) {
					bw.write(-1+"\n");
				} else {
					int num = stack.pop();
					bw.write(num+"\n");
				}
				break;
			case 3:			// 스택 내 개수 
				bw.write(stack.size()+"\n");
				break;
			case 4:
				bw.write(stack.isEmpty() ? 1+"\n" : 0+"\n");
				break;
			case 5:
				bw.write(stack.isEmpty() ? -1+"\n" : stack.peek()+"\n");
				break;
			default:
				break;
			}
		}
		bw.flush();
		bw.close();
	}

}
