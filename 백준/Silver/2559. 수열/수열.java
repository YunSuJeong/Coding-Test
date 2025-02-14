import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringTokenizer T = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		long window = 0;
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(T.nextToken());
			if( i < K ) window += num;					// 초기 윈도우값 계산
			arr[i] = num;
		}
		
		long max = window;
		for(int i=0; i<N-K; i++) {
			window = window - arr[i] + arr[i+K];
			max = Math.max(max, window);
		}
		System.out.println(max);
	}

}
