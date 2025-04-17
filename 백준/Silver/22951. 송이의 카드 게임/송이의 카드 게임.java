import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<int[]> queue = new LinkedList<int[]>();
		
		for(int i=1; i<=N; i++) {
			StringTokenizer card = new StringTokenizer(br.readLine());
			
			for(int j=0; j<K; j++) {
				int c = Integer.parseInt(card.nextToken());
				queue.offer(new int[] {i, c});
			}
		}
		
		int num = 0, card = 0;
		while( !queue.isEmpty() ) {
			int[] tmp = queue.poll();
			
			if( tmp == null ) break;
			
			num = tmp[0];
			card = tmp[1];
			
			for(int i=0; i<card-1; i++) {
				queue.offer(queue.poll());
			}
		}
		System.out.println(num+" "+card);
	}

}
