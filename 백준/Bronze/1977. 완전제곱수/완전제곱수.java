import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		
		int arr[] = new int[100];
		
		// 100까지 완전제곱수 저장
		for(int i=0; i<100; i++) {
			arr[i] = (i+1) * (i+1);
		}
		
		int min = arr[99], sum = 0;
		for(int i=0; i<100; i++) {
			if( arr[i] >= M && arr[i] <= N ) {
				sum += arr[i];
				min = Math.min(min, arr[i]);
			}
		}
		
		if( sum == 0 ) {
			System.out.println(-1);
		} else {
			System.out.println(sum);
			System.out.println(min);
		}
	}

}
