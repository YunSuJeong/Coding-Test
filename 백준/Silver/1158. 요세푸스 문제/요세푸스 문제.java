import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i=1; i<=N; i++) {
			queue.offer(i);
		}
		
		sb.append("<");
		while( true ) {
			for(int i=0; i<K-1; i++) {
				queue.offer(queue.poll());
			}
			sb.append(queue.poll()); 
			if( queue.isEmpty() ) {
				sb.append(">");
				break;
			} else {
				sb.append(", ");
			}
		}
		System.out.println(sb.toString());
	}

}