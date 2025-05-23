import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] number = {"ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"};
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			String t = st.nextToken();
			int N = Integer.parseInt(st.nextToken());
			
			int[] arr = new int[N];
			StringTokenizer str = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				String word = str.nextToken();
				
				int num = 0;
				switch (word) {
				case "ZRO":
					num = 0; break;
				case "ONE":
					num = 1; break;
				case "TWO":
					num = 2; break;
				case "THR":
					num = 3; break;
				case "FOR":
					num = 4; break;
				case "FIV":
					num = 5; break;
				case "SIX":
					num = 6; break;
				case "SVN":
					num = 7; break;
				case "EGT":
					num = 8; break;
				case "NIN":
					num = 9; break;
				}
				
				arr[i] = num;
			}
			
			Arrays.sort(arr);
			
			for(int i=0; i<N; i++) sb.append(number[arr[i]]+" ");
			
			System.out.println(t);
			System.out.println(sb.toString());
			sb.setLength(0);
		}
	}

}
