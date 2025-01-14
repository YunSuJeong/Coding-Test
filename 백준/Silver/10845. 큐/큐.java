import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		Deque<Integer> queue = new LinkedList<Integer>();
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			
			String cmd = st.nextToken();
			
			switch (cmd) {
			case "push":
				queue.add(Integer.parseInt(st.nextToken()));
				break;
			case "pop":
				sb.append(queue.isEmpty() ? -1+"\n" : queue.poll()+"\n");
				break;
			case "size":
				sb.append(queue.size()+"\n");
				break;
			case "empty":
				sb.append(queue.isEmpty() ? 1+"\n" : 0+"\n");
				break;
			case "front":
				sb.append(queue.isEmpty() ? -1+"\n" : queue.peekFirst()+"\n");
				break;
			case "back":
				sb.append(queue.isEmpty() ? -1+"\n" : queue.peekLast()+"\n");
				break;
			default:
				break;
			}
		}
		System.out.println(sb.toString());
	}

}
