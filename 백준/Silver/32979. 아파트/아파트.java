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
		
		int N = Integer.parseInt(br.readLine());
		int T = Integer.parseInt(br.readLine());
		StringTokenizer hands = new StringTokenizer(br.readLine());
		StringTokenizer nums = new StringTokenizer(br.readLine());
		
		Queue<Integer> queue = new LinkedList<Integer>();
		int[] b = new int[T];
		
		for(int i=0; i<N*2; i++) {
			queue.offer(Integer.parseInt(hands.nextToken()));
		}
		
		for(int i=0; i<T; i++) {
			b[i] = Integer.parseInt(nums.nextToken());
		}
	
		// 게임 시작
		for(int i=0; i<T; i++) {
			int apt = b[i];
			
			for(int j=0; j<apt-1; j++) {
				queue.offer(queue.poll());
			}
			
			sb.append(queue.peek()+" ");
		}
		System.out.println(sb.toString());
	}

}
