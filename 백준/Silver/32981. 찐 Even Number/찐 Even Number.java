import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int Q = Integer.parseInt(br.readLine());
		
		// 치토가 답변하는 수를 10^9+7로 나눈 나머지 모두 구하기
		long[] arr = new long[10000001];
		arr[1] = 5;
		arr[2] = 20;
		for(int i=3; i<=10000000; i++) {
			arr[i] = arr[i-1] * 5 % 1000000007;
		}
		
		// 결과 출력
		for(int i=0; i<Q; i++) {
			int N = Integer.parseInt(br.readLine());
			sb.append(arr[N]+"\n");
		}
		System.out.println(sb.toString());
	}

}
