import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[1000001];
		for(int i=0; i<N; i++) {
			StringTokenizer input = new StringTokenizer(br.readLine());
			
			int g = Integer.parseInt(input.nextToken());		// 얼음(g)
			int x = Integer.parseInt(input.nextToken());		// 양동이 좌표(x)
			arr[x] = g; 
		}
		
		// 얼음합의 최댓값
		int max = 0, sum = 0;
		for(int i=0; i<1000001; i++) {
			if( i < K*2+1 ) sum += arr[i];
			else {
				sum = sum - arr[i-K*2-1] + arr[i]; 
			}
			max = Math.max(max, sum);
		}
		System.out.println(max);
	}

}
