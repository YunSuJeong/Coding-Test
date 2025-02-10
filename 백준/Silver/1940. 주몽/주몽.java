import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[N];
		int cnt = 0;
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		} 
		
		Arrays.sort(arr);
		
		int left = 0, right = N-1;
		while( left < right ) {
			if( arr[left] + arr[right] <= M ) {
				if( arr[left] + arr[right] == M ) cnt++; 
				left++;
			} else {
				right--;
			}
		}
		System.out.println(cnt);
	}

}
