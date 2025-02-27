import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	public static int win = 0, lose = 0;
	public static int[] gyu, iny;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			gyu = new int[9];
			iny = new int[9];
			
			boolean[] arr = new boolean[18];
			for(int i=0; i<9; i++) {
				int num = Integer.parseInt(st.nextToken());
				arr[num-1] = true;
			}
			
			int idx1 = 0, idx2 = 0;
			for(int i=0; i<18; i++) {
				if( arr[i] ) {
					gyu[idx1] = i+1;
					idx1++;
				} else {
					iny[idx2] = i+1;
					idx2++;
				}
			}
			
			boolean[] visited = new boolean[9];
			
			dfs(0, visited, new int[9]);
			
			System.out.printf("#%d %d %d\n", tc, win, lose);
			win = 0;
			lose = 0;
		}
	}
	
	// dfs로 모든 경우의 수 찾기
	public static void dfs(int round, boolean[] visited, int[] result) {
		// 9라운드에 승패 결정
		if( round == 9 ) {
			// 점수 계산
			calcScore(result);
			return;
		}

		for(int i=0; i<9; i++) {
			if( !visited[i] ) {
				result[round] = iny[i];
				round++;
				visited[i] = true;

				dfs(round, visited, result);
				visited[i] = false;
				round--;
			}
		}
	}
	
	// 점수 계산 및 승패 결정
	public static void calcScore(int[] result) {
		int sum1 = 0, sum2 = 0;
		
		for(int i=0; i<9; i++) {
			if( gyu[i] > result[i] ) sum1 += (gyu[i] + result[i]);
			else if( gyu[i] < result[i] ) sum2 += (gyu[i] + result[i]);
		}
		
		if( sum1 > sum2 ) win++;
		else if( sum1 < sum2 ) lose++;
	}
	
}
