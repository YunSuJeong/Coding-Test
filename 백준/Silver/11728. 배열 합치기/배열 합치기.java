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
//		for(int i=0; i<N; i++) {
//			arr[i] = Integer.parseInt(A.nextToken());
//		}
//		for(int i=N; i<N+M; i++) {
//			arr[i] = Integer.parseInt(B.nextToken());
//		}
//		
//		Arrays.sort(arr);
//		
//		for(int n : arr) {
//			sb.append(n+" ");
//		}
//		System.out.println(sb.toString());
		
		// 2. 이미 정련된 A, B를 비교하며 더 작은 수부터 출력
		int[] arrA = new int[N];
		int[] arrB = new int[M];
		for(int i=0; i<N; i++) {
			arrA[i] = Integer.parseInt(A.nextToken());
		}
		for(int i=0; i<M; i++) {
			arrB[i] = Integer.parseInt(B.nextToken());
		}
		
		int idx1 = 0, idx2 = 0;
		while( idx1 < N && idx2 < M ) {
			if( arrA[idx1] > arrB[idx2] ) {
				sb.append(arrB[idx2]+" ");
				idx2++;
			} else if( arrA[idx1] < arrB[idx2] ) {
				sb.append(arrA[idx1]+" ");
				idx1++;
			} else {
				sb.append(arrA[idx1]+" ");
				sb.append(arrB[idx2]+" ");
				idx1++;
				idx2++;
			}
		}
		
		// 배열A 탐색만 완료 : 나머지 B출력
		while( idx1 >= N && idx2 < M ) {
			sb.append(arrB[idx2]+" ");
			idx2++;
		}
		// 배열B 탐색만 완료 : 나머지 A출력
		while( idx2 >= M && idx1 < N ) {
			sb.append(arrA[idx1]+" ");
			idx1++;
		}
		System.out.println(sb.toString());
	}

}
