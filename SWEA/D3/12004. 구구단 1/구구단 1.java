import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		boolean[] arr = new boolean[101];
		for(int i=1; i<=9; i++) {
			for(int j=1; j<=9; j++) {
				arr[i*j] = true;
			}
		}
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			System.out.printf("#%d %s\n", tc, arr[N] ? "Yes" : "No");
		}
	}

}
