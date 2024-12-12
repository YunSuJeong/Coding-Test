import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int arr[] = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		// 1) Selection Sort
		for(int i=0; i<N; i++) {
			// 1. 최대값 찾기
			int maxIdx = 0;
			for(int j=1; j<N-i; j++) {
				if( arr[maxIdx] < arr[j] ) maxIdx = j;
			}
			
			// 2. 맨 끝과 교환
			int tmp = arr[maxIdx];
			arr[maxIdx] = arr[N-i-1];
			arr[N-i-1] = tmp;
		}
		
		for(int n : arr) {
			System.out.println(n);
		}
		
	}

}
