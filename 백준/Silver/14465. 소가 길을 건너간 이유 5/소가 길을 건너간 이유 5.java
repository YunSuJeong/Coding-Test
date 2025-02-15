import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		for(int i=0; i<B; i++) {
			int num = Integer.parseInt(br.readLine());
			arr[num-1] = 1;
		}
		
		// 초기 윈도우 값 세팅
		int cnt = 0;
		for(int i=0; i<K; i++) {
			cnt += arr[i];
		}
		
		int min = cnt;
		for(int i=0; i<N-K; i++) {
			cnt = cnt - arr[i] + arr[i+K];
			min = Math.min(min, cnt);
		}
		System.out.println(min);
	}

}
