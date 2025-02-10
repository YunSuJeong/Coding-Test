import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringTokenizer A = new StringTokenizer(br.readLine());
		StringTokenizer B = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N+M];
		
		// 1. A, B 한 배열에 입력받아 정렬하여 출력하기
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(A.nextToken());
		}
		for(int i=N; i<N+M; i++) {
			arr[i] = Integer.parseInt(B.nextToken());
		}
		
		Arrays.sort(arr);
		
		for(int n : arr) {
			sb.append(n+" ");
		}
		System.out.println(sb.toString());
	}

}
