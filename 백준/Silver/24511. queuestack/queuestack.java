import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());		// 자료구조 개수
		String A = br.readLine();						// 자료구조 수열
		String B = br.readLine();						// 원소 수열
		int M = Integer.parseInt(br.readLine());		// 삽입할 수열의 길이
		String C = br.readLine();						// 삽입할 수열
		
		StringTokenizer stA = new StringTokenizer(A);
		StringTokenizer stB = new StringTokenizer(B);
		StringTokenizer stC = new StringTokenizer(C);
		
		// 1) 시간 초과
//		int arr[][] = new int[N][2];
//		int insert[] = new int[M];
//		for(int i=0; i<N; i++) {
//			arr[i][0] = Integer.parseInt(stA.nextToken());
//			arr[i][1] = Integer.parseInt(stB.nextToken());
//		}
//		
//		for(int i=0; i<M; i++) {
//			insert[i] = Integer.parseInt(stC.nextToken());
// 		}
//		
//		for(int i=0; i<M; i++) {
//			int x = insert[i];
//			for(int j=0; j<N; j++) {
//				Queue<Integer> queue = new LinkedList<Integer>();
//				// 자료구조가 큐일 때만 수행, stack일 땐 x의 값에 변화가 없다.
//				if( arr[j][0] == 0 ) {
//					queue.offer(arr[j][1]); 
//					queue.offer(x);
//					x = queue.poll();
//					arr[j][1] = queue.peek();
//				}
//			}
//			bw.write(x+" ");
//		}
		
		
		// 2) 큐인 자료구조만 큐에 저장 -> 시간초과
//		int insert[] = new int[M];
//		Queue<Integer> queue = new LinkedList<Integer>();
//		for(int i=0; i<N; i++) {
//			int a = Integer.parseInt(stA.nextToken());
//			int b = Integer.parseInt(stB.nextToken());
//			if( a == 0 ) {
//				queue.offer(b);
//			}
//		}
//		for(int i=0; i<M; i++) {
//			insert[i] = Integer.parseInt(stC.nextToken());
// 		}
//		
//		for(int i=0; i<M; i++) {
//			int x = insert[i];
//			for(int j=0; j<queue.size(); j++) {
//				queue.offer(x);
//				x = queue.poll();
//			}
//			sb.append(x+" ");
//		}
		
		// 3) Deque사용하여 중첩 for문 없애기
		int insert[] = new int[M];
		Deque<Integer> deque = new LinkedList<Integer>();
		for(int i=0; i<N; i++) {
			int a = Integer.parseInt(stA.nextToken());
			int b = Integer.parseInt(stB.nextToken());
			if( a == 0 ) {
				deque.offer(b);
			}
		}
		for(int i=0; i<M; i++) {
			insert[i] = Integer.parseInt(stC.nextToken());
 		} 
		
		for(int i=0; i<M; i++) {
			deque.offerFirst(insert[i]);        // 큐의 맨 앞에 넣고
			sb.append(deque.pollLast()+" ");    // 맨 뒤 요소를 출력
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
