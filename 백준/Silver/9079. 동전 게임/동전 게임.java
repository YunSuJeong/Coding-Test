import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	
	public static int min = -1;
	public static String[][] arr;
	public static int[][] flip = {{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}};
	
	static class Coin{
		String state;
		int cnt;
		
		public Coin(String state, int cnt) {
			this.state = state;
			this.cnt = cnt;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<T; tc++) {
			arr = new String[3][3];
			
			for(int i=0; i<3; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<3; j++) {
					arr[i][j] = st.nextToken();
					sb.append(arr[i][j]);
				}
			}
			
			bfs(sb.toString());
			
			System.out.println(min);
			sb.setLength(0);
			min = -1;
		}
	}
	
	public static void bfs(String s) {
		Queue<Coin> queue = new LinkedList<>();
		Set<String> visited = new HashSet<String>();		// 방문처리 위한 set
		StringBuilder sb = new StringBuilder();
		
		Coin coin = new Coin(s, 0);
		queue.offer(coin);
		
		while( !queue.isEmpty() ) {
			Coin tmp = queue.poll();
			visited.add(tmp.state);
			
			// 모두 같은 면이라면 최소 횟수 세팅하고 while문 탈출
			if( tmp.state.equals("HHHHHHHHH") || tmp.state.equals("TTTTTTTTT") ) {
				min = tmp.cnt;
				break;
			}
			
			// 가로, 세로, 대각선 연산 완전 탐색
			for(int i=0; i<8; i++) {
				char[] arr = tmp.state.toCharArray();
				for(int j : flip[i] ) {
					arr[j] = arr[j] == 'H' ? 'T' : 'H';
				}
				for(char c : arr) sb.append(c);
				String str = sb.toString();
				
				// 이전 상태에 없는 연산만 큐에 넣기
				if( !visited.contains(str) ) {
					queue.offer(new Coin(str, tmp.cnt+1));
				}
				sb.setLength(0);
			}
			
		}
	}

}
