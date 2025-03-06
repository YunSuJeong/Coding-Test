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
			StringTokenizer arrive = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int[] arr = new int[11112];			// 매 초 제공가능한 붕어빵 개수
			int[] time = new int[N];			// 사람들이 도착하는 시간
			
			for(int i=M; i<=11111; i++) {
				if( i % M == 0 ) arr[i] = arr[i-1] + K;
				else arr[i] = arr[i-1];
			}
			
			for(int i=0; i<N; i++) {
				time[i] = Integer.parseInt(arrive.nextToken());
			}
			
			// 먼저 온 순으로 정렬
			Arrays.sort(time);
			
			int cnt = 0;		// 현재까지 제공된 붕어빵 개수 
			for(int i=0; i<N; i++) {
				if( arr[time[i]] - cnt > 0 ) cnt++;
			}
			
			String result = "Impossible";
			if( cnt == N ) result = "Possible";
			
			System.out.printf("#%d %s\n", tc, result);
		}
	}

}
