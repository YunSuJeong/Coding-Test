import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			String str = br.readLine();
			int H = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int[] arr = new int[str.length()+1];
			for(int i=0; i<H; i++) {
				int h = Integer.parseInt(st.nextToken());
				arr[h]++;
			}
			
			// 맨 앞은 미리 예외처리
			for(int i=0; i<arr[0]; i++) {
				sb.append("-");
			}
			
			for(int i=0; i<str.length(); i++) {
				sb.append(str.charAt(i));
				for(int j=0; j<arr[i+1]; j++) {
					sb.append("-");
				}
			}
			System.out.printf("#%d %s\n", tc, sb.toString());;
			sb.setLength(0);
		}
	}

}
