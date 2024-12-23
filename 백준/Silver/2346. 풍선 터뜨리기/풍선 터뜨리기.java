import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.ArrayDeque;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		
		// 1) deque와 map사용 -> 메모리 초과
//		Deque<Integer> deque = new LinkedList<Integer>();
//		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
//		for(int i=1; i<=N; i++) {
//			int num = Integer.parseInt(st.nextToken());
//			deque.offer(num);
//			map.put(num, i);
//		}
//		
//		int num = 0;
//		for(int i=0; i<N; i++) {
//			if( i == 0 ) {
//				num = deque.poll();
//				bw.write(map.get(num)+" ");
//			} else {
//				if( num > 0 ) {
//					// 양수일 때, 적힌 숫자만큼 큐 뒤에 넣어서 맨 마지막 값을 읽는다.
//					for(int j=1; j<=num; j++) {
//						deque.offer(deque.poll());
//					}
//					num = deque.pollLast();
//				} else {
//					// 음수일 때, 적힌 숫자만큼 큐 앞에 넣어서 첫번째 값을 읽는다.
//					for(int j=Math.abs(num); j>=1; j--) {
//						deque.offerFirst(deque.pollLast());
//					}
//					num = deque.poll();
//				}
//				bw.write(map.get(num)+" ");
//			}
//		}
		
		// 2) deque에서 인덱스까지 관리
		Deque<int[]> deque = new ArrayDeque<int[]>();
		for(int i=1; i<=N; i++) {
			deque.offer(new int[] {i, Integer.parseInt(st.nextToken())});
		}
		while( !deque.isEmpty() ) {
			int arr[] = deque.poll();
			
			int idx = arr[0];
			int num = arr[1];
			
			bw.write(idx+" ");
			
			if( deque.isEmpty() ) break;
			
			if( num > 0 ) {
				for(int i=0; i<num-1; i++) {
					deque.offer(deque.poll());
				}
			} else {
				for(int i=0; i<Math.abs(num); i++) {
					deque.offerFirst(deque.pollLast());
				}
			}
		}
			
		bw.flush();
		bw.close();
	}

}
