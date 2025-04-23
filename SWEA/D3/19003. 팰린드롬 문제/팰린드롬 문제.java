import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	public static int M;
	public static boolean[] isPalin;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			String[] arr = new String[N];
			isPalin = new boolean[N];
			boolean[] used = new boolean[N];
			
			int len = 0;
			for(int i=0; i<N; i++) {
				arr[i] = br.readLine();
				isPalin[i] = isPalin(arr[i]);
				if( isPalin[i] ) len = M;
			}
			
			for(int i=0; i<N; i++) {
				if( !used[i] ) {
					for(int j=M-1; j>=0; j--) {
						sb.append(arr[i].charAt(j));
					}
					String tmp = sb.toString();

					for(int j=0; j<N; j++) {
						if( i != j && arr[j].equals(tmp) ) {
							len += M*2;
							used[i] = true;
							used[j] = true;
						}
					}
					sb.setLength(0);
				}
			}
			
			System.out.printf("#%d %d\n", tc, len);
		}
	}
	
	// 단어 자체가 팰린드롬인지 확인
	public static boolean isPalin(String str) {
		boolean flag = true;
		for(int i=0; i<M/2; i++) {
			if( str.charAt(i) != str.charAt(M-i-1) ) {
				flag = false;
				break;
			}
		}
		return flag;
	}

}
