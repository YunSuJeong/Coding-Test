import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static int A, B, min = -1;
	public static Map<Long, Integer> map = new HashMap<Long, Integer>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		bfs(A);
		
		System.out.println(min);
	}
	
	public static void bfs(long n) {
		Queue<Long> queue = new LinkedList<Long>();
		
		queue.offer(n);
		map.put(n, 0);
		while( !queue.isEmpty() ) {
			if( min >= 0 ) break;			// 이미 최소 연산 횟수를 구했다면 조기종료
			
			n = queue.poll();
			
			long num1 = n * 2;				// 2를 곱한다.
			long num2 = n * 10 + 1;			// 1을 수의 가장 오른쪽에 추가한다. 
			
			if( num1 == B || num2 == B ) {
				min = map.get(n) + 2;
				break;
			}
			
			if( num1 < B ) {
				queue.offer(num1);
				map.put(num1, map.get(n)+1);
			}
			if( num2 < B ) {
				queue.offer(num2);
				map.put(num2, map.get(n)+1);
			}
		}
	}

}
