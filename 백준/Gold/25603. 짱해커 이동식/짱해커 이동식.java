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
		
		StringTokenizer Ni = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(Ni.nextToken());
		}
		
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		for(int i=0; i<K; i++) {
			min = Math.min(min, arr[i]);
			max = min;
		}
		
		for(int i=1; i<=N-K; i++) {
			min = Integer.MAX_VALUE;
			for(int j=i; j<i+K; j++) {
				min = Math.min(min, arr[j]);
			}
			max = Math.max(max, min);
		}
		System.out.println(max);
	}

}
