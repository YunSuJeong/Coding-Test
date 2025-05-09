import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Deque<Integer> deque = new ArrayDeque<Integer>();
		for(int i=1; i<=N; i++) {
			deque.offer(i);
		}
		
		int d = 1, cnt = 0;
		while( !deque.isEmpty() ) {
			if( d == 1 ) {
				for(int i=0; i<K-1; i++) {
					deque.offer(deque.poll());
				}
				sb.append(deque.poll()+"\n");
			} else {
				for(int i=0; i<K-1; i++) {
					deque.offerFirst(deque.pollLast());
				}
				sb.append(deque.pollLast()+"\n");
			}
			cnt++;
			if( cnt == M ) {
				d = d == 1 ? -1 : 1;
				cnt = 0;
			}
		}
		System.out.println(sb.toString());
	}

}
