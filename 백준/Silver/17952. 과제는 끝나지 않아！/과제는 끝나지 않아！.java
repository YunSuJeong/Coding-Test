import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[N][2];
		// 새로 들어온 과제를 제일 먼저 처리해야 하기때문에 stack이용
		Stack<Integer> stack = new Stack<Integer>();		
		
		long score = 0;				// 성애가 받을 점수
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int cmd = Integer.parseInt(st.nextToken());
			
			if( cmd == 1 ) {
				int A = Integer.parseInt(st.nextToken());
				int T = Integer.parseInt(st.nextToken());
				
				stack.push(i);				
				arr[i][0] = A;
				arr[i][1] = T - 1;			// 과제를 바로 시작하기 때문에 -1로 저장
			} else {
				// 스택에 해야할 과제가 남아있을 때만, 가장 최근 과제를 1분 해결한다.
				if( !stack.isEmpty() ) {
					arr[stack.peek()][1]--;
				}
			}
			
			// 현재 과제를 끝냈다면 해당 과제 점수를 얻는다.
			if( !stack.isEmpty() && arr[stack.peek()][1] == 0 ) {
				score += arr[stack.pop()][0];
			}
		}
		System.out.println(score);
	}

}
