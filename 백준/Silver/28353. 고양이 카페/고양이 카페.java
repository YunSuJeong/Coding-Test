import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringTokenizer w = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(w.nextToken());
		}
		
		// 무게 오름차순 정렬
		Arrays.sort(arr);
		
		int left = 0, right = N-1, cnt = 0;
		while( left < right ) {
			if( arr[left] + arr[right] > K ) {
				right--;
			} else {
				cnt++;
				left++;
				right -= 1;
			}
		}
		System.out.println(cnt);
	}

}
