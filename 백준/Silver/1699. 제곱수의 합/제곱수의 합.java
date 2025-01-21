import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int arr[] = new int[N+1];				// 항의 최소개수 저장되는 배열
		// 제곱수일 때 최소개수 1로 세팅
		for(int i=1; i*i<=N; i++) {
			arr[i*i] = 1;
		}
		
		// 나머지 최소개수 구하기
		for(int i=2; i<=N; i++) {
			arr[i] = 100000;
			// 현재 수보다 작은 제곱수들 모두 체크
			// f(n) = f(제곱수) + f(i-제곱수)
			for(int j=1; j*j<=i; j++) {
				arr[i] = Math.min(arr[i], 1 + arr[i-j*j]);
			}
		}
		System.out.println(arr[N]);
	}

}
