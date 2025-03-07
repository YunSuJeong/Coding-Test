import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] maxA = new int[N];
		maxA[0] = 0;
		int min = arr[0], max = arr[0];
		for(int idx=1; idx<N; idx++) {
			max = arr[idx];
			maxA[idx] = Math.max(maxA[idx-1], max-min);
			
			min = Math.min(min, arr[idx]);
		}
		
		for(int num : maxA) {
			sb.append(num+" ");
		}
		System.out.println(sb.toString());
	}

}
