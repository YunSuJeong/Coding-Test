import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1; tc<=10; tc++) {
			int T = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			Deque<Integer> deque = new ArrayDeque<Integer>();
			for(int i=0; i<8; i++) {
				deque.offer(Integer.parseInt(st.nextToken()));
			}
			
			int cycle = 1;
			while( true ) {
				
				if( deque.peek() - cycle <= 0 ) {
					deque.poll();
					deque.offer(0);
					break;
				}
				
				deque.offer(deque.poll()-cycle);
				
				cycle++;
				if( cycle > 5 ) cycle = 1;
			}
			
			for(int i=0; i<8; i++) sb.append(deque.poll()+" ");
			System.out.printf("#%d %s\n", T, sb.toString());
			sb.setLength(0);
		}
	}

}
