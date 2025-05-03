import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	
	public static int N, cnt = 0;
	public static String[] arr;
	public static boolean[] alpha;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			
			arr = new String[N];
			for(int i=0; i<N; i++) {
				arr[i] = br.readLine();
			}
			
			cnt = 0;
			alpha = new boolean[26];
			
			// 모든 세트 조합 탐색
			combination(0, alpha, 0);
			
			System.out.printf("#%d %d\n", tc, cnt);
		}
	}
	
	public static void combination(int idx, boolean[] alpha, int count) {
		if( idx == N ) {
			// 모든 알파벳이 포함되어있다면 카운팅
			if( count == 26 ) cnt++;
			return;
		}
		
		boolean[] tmp = Arrays.copyOf(alpha, 26);
		combination(idx+1, tmp, count);
		
		for(int i=0; i<arr[idx].length(); i++) {
			char c = arr[idx].charAt(i);
			if( !alpha[c-97] ) {
				alpha[c-97] = true;
				count++;
			}
		}
		combination(idx+1, alpha, count);
	}

}
