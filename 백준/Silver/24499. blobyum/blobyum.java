import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringTokenizer A = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(A.nextToken());
		}
		
		// 첫 윈도우의 합 
		int sum = 0;
		for(int i=0; i<K; i++) {
			sum += arr[i];
		}
		
		int window = sum;				// 이전 윈도우의 합을 저장
		for(int i=0; i<N-1; i++) {
			window = window - arr[i] + arr[(i+K)%N];			
			sum = Math.max(sum, window);
		}
		System.out.println(sum);
	}

}
