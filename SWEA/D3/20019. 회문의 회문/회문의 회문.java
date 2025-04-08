import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			String str = br.readLine();
			
			int N = str.length(), mid = (N-1)/2;
			char[] arr = str.toCharArray();
			boolean flag = true;
			// 전체
			for(int i=0; i<mid; i++) {
				if( arr[i] != arr[N-i-1] ) {
					flag = false;
					break;
				}
			}
			
			// 처음
			if( flag ) {
				for(int i=0; i<mid/2; i++) {
					if( arr[i] != arr[mid-i-1] ) {
						flag = false;
						break;
					}
				}
			}
			
			// 마지막
			if( flag ) {
				for(int i=mid+1; i<(mid+N)/2; i++) {
					if( arr[i] != arr[mid+N-i] ) {
						flag = false;
						break;
					}
				}
			}
			
			System.out.printf("#%d %s\n", tc, flag ? "YES" : "NO");
		}
	}

}
