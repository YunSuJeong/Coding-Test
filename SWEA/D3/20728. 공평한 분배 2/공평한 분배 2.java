import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			StringTokenizer a = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[] arr = new int[N];
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(a.nextToken());
			}
			
			Arrays.sort(arr);
			
            // 슬라이딩 윈도우 방식으로 모든 최대/최소 차이 비교하여 최솟값 구하기 : 고정 윈도우 크기 M
			int min = Integer.MAX_VALUE;
			for(int i=0; i<=N-M; i++) {
				min = Math.min(min, arr[i+M-1]-arr[i]);
			}
			System.out.printf("#%d %d\n", tc, min);
		}
	}

}
