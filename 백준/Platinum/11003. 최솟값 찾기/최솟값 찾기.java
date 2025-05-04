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
		StringTokenizer A = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(A.nextToken());
		}
		
		Deque<Integer> deque = new ArrayDeque<Integer>();
		for(int i=0; i<N; i++) {
			if( i == 0 ) {
				deque.offer(i);
			} else {
				if( i - deque.peek() >= L ) {
					deque.poll();
				}
				
				while( !deque.isEmpty() && arr[i] < arr[deque.peekLast()] ) {
					deque.pollLast();
				}
				
				deque.offer(i);
			}
			sb.append(arr[deque.peek()]+" ");
		}
		System.out.println(sb.toString());
	}

}
