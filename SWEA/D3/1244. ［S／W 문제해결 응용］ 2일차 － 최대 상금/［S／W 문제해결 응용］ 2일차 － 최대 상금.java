import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
	
	public static char[] arr;
	public static int C, max = Integer.MIN_VALUE;
	public static Set<String>[] set;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String number = st.nextToken();
			arr = number.toCharArray();
		
			C = Integer.parseInt(st.nextToken());
			set = new HashSet[C+1];
			for(int i=0; i<=C; i++) {
				set[i] = new HashSet<String>();
			}
			
			// 조합 완전 탐색하기
			dfs(0);
			
			System.out.printf("#%d %d\n", tc, max);
			max = Integer.MIN_VALUE;
		}
	}
	
	public static void dfs(int depth) {
		if( depth == C ) {
			return;
		}
		
		for(int i=0; i<arr.length; i++) {
			for(int j=i+1; j<arr.length; j++) {
				// 교환
				char tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
				
				StringBuilder sb = new StringBuilder();
				for(char a : arr) sb.append(a);
				String str = sb.toString();

				if( !set[depth+1].contains(str) ) {
					set[depth+1].add(str);
					if(depth+1 == C) max = Math.max(max, Integer.parseInt(str));
					dfs(depth+1);
				}
				sb.setLength(0);
				
				// 백트래킹
				arr[j] = arr[i];
				arr[i] = tmp;
			}
		}
	}

}
