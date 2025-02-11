import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringTokenizer T = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] arr= new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(T.nextToken());
		}
		
		Arrays.sort(arr);
		
		int left = 0, right = N-1, cycle = 0;
		long sum = 0;
		while( cycle < K ) {
			if( cycle % 2 == 0 ) {
				if( cycle == 0 ) sum += arr[right];
				else {
					sum += arr[right]-arr[left];
					left++;
				}
				right--;
			}
			cycle++;
		}
		System.out.println(sum);
		
	}

}
