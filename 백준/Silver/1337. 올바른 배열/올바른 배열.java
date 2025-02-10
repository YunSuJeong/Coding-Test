import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		if( N == 1 ) System.out.println(4);
		else {
			int left = 0, right = 1, max = 0, cnt = 1;
			
			while( left < N-1 && right < N ) {
				if( arr[right] < arr[left] + 5 ) {
					cnt++;
					right++;
				} else {
					max = Math.max(max, cnt);
					left += 1;
					right = left + 1;
					cnt = 1;
				}
			}
            
            // 마지막으로 구한 cnt값 반영되어야함
			max = Math.max(max, cnt);
			System.out.println(5-max);
		}
	}

}
